package com.muhardin.endy.belajar.socket;

import java.net.*;
import java.io.*;

public class KirimFile {
	public static void main(String[] x) throws Exception {
		// 1. File yang ingin dikirim
		InputStream is 
			= KirimFile.class
			.getResourceAsStream("/akb481.jpg");

		// 2. Buka socket
		String ipPenerima = "127.0.0.1";
		Integer portPenerima = 10000;
		Socket s = new Socket(ipPenerima, portPenerima);
		OutputStream os = s.getOutputStream();
		// 3. Kirim isi file
		int data;
		while((data = is.read()) != -1){
			os.write(data);
		}

		// 4. Tutup resources
		is.close();
		os.close();
		s.close();
	}
}