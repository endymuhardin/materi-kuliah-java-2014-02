package com.muhardin.endy.belajar.csv;

import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class ImportMahasiswa {
	private static final String SQL_INSERT = 
		"insert into mahasiswa (npm,nama,email,tanggal_lahir,tahun_masuk) "+
		"values (?,?,?,?,?)";

	private Connection connection;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	public ImportMahasiswa(Connection c){
		this.connection = c;
	}

	public void importFile(File f, Boolean skipHeader){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));

			String data;

			if(skipHeader){
				data = reader.readLine();
			}

			data = reader.readLine();
			while(data != null){
				System.out.println("Data : "+data);

				String[] mhs = data.split(",");
				insertData(mhs);

				data = reader.readLine();
			}

			reader.close();
		} catch (Exception err){
			err.printStackTrace();
		}
	}

	private void insertData(String[] m) throws Exception {
		PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
		ps.setInt(1, Integer.valueOf(m[0]));
		ps.setString(1, m[1]);
		ps.setString(2, m[2]);
		ps.setString(3, m[3]);
		java.util.Date tanggalLahir = formatter.parse(m[4]);
		ps.setDate(4, new java.sql.Date(tanggalLahir.getTime()));
		ps.setInt(5, Integer.valueOf(m[5]));
		ps.executeUpdate();
	}

}