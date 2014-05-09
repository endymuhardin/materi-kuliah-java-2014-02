package com.muhardin.endy.belajar.io;

import java.io.*;

public class DemoBacaFile {
	public static void main(String[] x) throws Exception {
		// 1. Buat variabel bertipe FileReader
		String namafile = "src/main/resources/mahasiswa.csv";
		FileReader fr = new FileReader(namafile);

		// 2. Bungkus dalam BufferedReader
		//    supaya ada method readLine
		BufferedReader reader = 
			new BufferedReader(fr);

		// 3. Looping, baca data, dan tampilkan
		String data = reader.readLine(); // header, ignore
		data = reader.readLine();
		while(data != null){
			System.out.println("=====================");
			String[] mahasiswa = data.split(",");
			System.out.println("NPM : "+mahasiswa[0]);
			System.out.println("Nama : "+mahasiswa[1]);
			System.out.println("Email : "+mahasiswa[2]);
			data = reader.readLine();
		}

		// 4. Tutup file
		reader.close();
	}
}