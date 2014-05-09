package com.muhardin.endy.belajar.io;

import java.io.*;

public class DemoCopyFile {
	public static void main(String[] x) throws Exception {
		FileReader asal 
			= new FileReader("src/main/resources/mahasiswa.csv");

		FileWriter tujuan 
			= new FileWriter("target/mahasiswa.csv");

		System.out.println("=======================");
		int data;
		while((data = asal.read()) != -1){
			System.out.print((char)data);
			tujuan.write(data);
			tujuan.flush();
		}
		System.out.println("\n=======================");
		asal.close();
		tujuan.close();
	}
}