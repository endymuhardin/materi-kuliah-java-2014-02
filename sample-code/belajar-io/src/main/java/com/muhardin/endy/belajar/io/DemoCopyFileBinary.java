package com.muhardin.endy.belajar.io;

import java.io.*;

public class DemoCopyFileBinary {
	public static void main(String[] x) throws Exception {
		FileInputStream asal 
			= new FileInputStream("src/main/resources/akb481.jpg");

		FileOutputStream tujuan 
			= new FileOutputStream("target/akb481.jpg");

		int data;
		while((data = asal.read()) != -1){
			tujuan.write(data);
			tujuan.flush();
		}
		
		asal.close();
		tujuan.close();
	}
}