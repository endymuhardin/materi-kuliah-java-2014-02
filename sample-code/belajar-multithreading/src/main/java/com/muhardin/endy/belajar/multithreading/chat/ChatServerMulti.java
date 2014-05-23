package com.muhardin.endy.belajar.multithreading.chat;

import java.io.*;
import java.net.*;

public class ChatServerMulti {
	public static void main(String[] x) throws Exception {
		Boolean jalan = true;

		// 1. Input Konfigurasi
		BufferedReader input 
			= new BufferedReader(
				new InputStreamReader(System.in));

		System.out.println("Masukkan nama : ");
		String nama = input.readLine();
		System.out.println("Halo "+nama);

		System.out.println("Masukkan port Anda : ");
		Integer port = Integer.parseInt(input.readLine());

		// 2. Start socket server
		final ServerSocket server = new ServerSocket(port);
		System.out.println("Menunggu koneksi di port "+port);

		while(jalan){
			Socket koneksi = server.accept();
			// 3. Terima koneksi dalam thread baru
			new ChatThread(koneksi).start();
		}

	}

	private static class ChatThread extends Thread {
		private Socket koneksi;

		ChatThread(Socket k){
			this.koneksi = k;
		}

		public void run(){
			try {
				System.out.print("Terima koneksi dari alamat IP ");
				System.out.println(((InetSocketAddress)koneksi.getRemoteSocketAddress()).getAddress());		

				// 4. Tampilkan data selama belum bye
				BufferedReader chatIncoming 
					= new BufferedReader(new InputStreamReader(koneksi.getInputStream()));

				String msg  = chatIncoming.readLine();
				while(msg != null && !"bye".equalsIgnoreCase(msg)){
					System.out.println(msg);
					msg = chatIncoming.readLine();
				}
				chatIncoming.close();
				koneksi.close();
			} catch (Exception err){
				err.printStackTrace();
			}
		}
	}
}