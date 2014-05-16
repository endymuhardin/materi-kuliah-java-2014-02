package com.muhardin.endy.belajar.socket;

import java.net.*;

public class ClientDemo {
	public static void main(String[] x) throws Exception {
		// 1. IP Address dan Port Server
		String ipServer = "127.0.0.1";
		Integer portServer = 10000;

		// 2. Connect menggunakan socket
		Socket s = new Socket(ipServer, portServer);

		// 3. Tampilkan informasi server
		InetSocketAddress server = (InetSocketAddress) s.getRemoteSocketAddress();
		System.out.println("IP server : "+server.getAddress());
		System.out.println("Port server : "+server.getPort());
		System.out.println("Hostname server : "+server.getHostName());

		// 4. Close koneksi
		s.close();
	}
}