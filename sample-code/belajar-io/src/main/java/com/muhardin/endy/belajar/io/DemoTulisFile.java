package com.muhardin.endy.belajar.io;

import java.io.*;

public class DemoTulisFile {
	public static void main(String[] x) throws Exception {
		// 1. Writer ke file tujuan
		String namafile = "target/output.txt";
		FileWriter output = new FileWriter(namafile);

		// 2. Tangkap input dari command line 
		//    menggunakan BufferedReader
		BufferedReader reader 
			= new BufferedReader(
				new InputStreamReader(System.in));

		// 3. Beri aba-aba untuk user
		System.out.println("Silahkan mengetik. Ketik exit untuk selesai");

		String data;
		while((data = reader.readLine()) != null){
			// kalau kita ketik exit, selesai loop
			if("exit".equalsIgnoreCase(data)) {
				break;
			}
			output.write(data);
			output.write("\r\n");
			output.flush();
		}

		reader.close();
	}
}