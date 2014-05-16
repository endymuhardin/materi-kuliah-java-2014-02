package com.muhardin.endy.belajar.socket;

import java.net.*;
import java.io.*;

public class TerimaFile{
	public static void main(String[] x) throws Exception {
		// 1. File tujuan
		FileOutputStream output 
			= new FileOutputStream("target/akb481.jpg");

		// 2. Buka port
		Integer port = 10000;
		ServerSocket ss = new ServerSocket(port);
		System.out.println("Penerima siap di port "+port);

		// 3. Terima koneksi
		Socket s = ss.accept();
		InputStream is = s.getInputStream();

		// 4. Terima data
		int data;
		while((data = is.read())!= -1){
			output.write(data);
		}

		// 5. Close resources
		output.close();
		is.close();
		s.close();
	}
}