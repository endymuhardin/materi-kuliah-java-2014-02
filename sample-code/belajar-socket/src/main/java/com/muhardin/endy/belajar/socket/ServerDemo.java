package com.muhardin.endy.belajar.socket;

import java.net.*;

public class ServerDemo {
	public static void main(String[] x) throws Exception {
		// 1. Buka server socket di port 10000
		ServerSocket ss = new ServerSocket(10000);

		// 2. Kalau ada client yang connect, terima
		Socket s = ss.accept();

		// 3. Tampilkan informasi client
		InetSocketAddress client = (InetSocketAddress) s.getRemoteSocketAddress();
		System.out.println("IP Client : "+client.getAddress());
		System.out.println("Port Client : "+client.getPort());
		System.out.println("Hostname Client : "+client.getHostName());

		// 4. Terima data

		// 5. Tutup koneksi
		s.close();
	}
}