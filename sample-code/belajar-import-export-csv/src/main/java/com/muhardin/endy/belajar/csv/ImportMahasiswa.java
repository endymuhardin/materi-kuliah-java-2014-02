package com.muhardin.endy.belajar.csv;

import java.sql.*;
import java.io.*;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.util.Map;
import java.util.TreeMap;

public class ImportMahasiswa {
	private static final String SQL_INSERT = 
		"insert into mahasiswa (id,npm,nama,email,tanggal_lahir,tahun_masuk) "+
		"values (?,?,?,?,?,?)";

	private Connection connection;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

	private Map<Integer, String> errors = new TreeMap<Integer, String>();

	public ImportMahasiswa(Connection c){
		this.connection = c;
		formatter.setLenient(false);
	}

	public void importFile(File input, Boolean skipHeader, File errorFile){
		try {
			errors.clear();
			BufferedReader reader = new BufferedReader(new FileReader(input));

			Integer baris = 0;
			String data = null;

			if(skipHeader){
				baris++;
				data = reader.readLine();
			}

			
			while((data = reader.readLine()) != null){
				baris++;
				System.out.println("Data : "+data);

				String[] mhs = data.split(",");
				System.out.println("Jumlah field hasil split : "+mhs.length);
				if(mhs.length != 6){
					errors.put(baris, "Jumlah field salah");
					continue;
				}

				insertData(baris,mhs);
			}

			reader.close();

			if(!errors.isEmpty()) {
				tulisErrorKeFile(errors, errorFile);
			}

		} catch (Exception err){
			err.printStackTrace();
		}
	}

	private void insertData(Integer baris, String[] m) throws Exception {
		PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
		ps.setInt(1, Integer.valueOf(m[0]));
		ps.setString(2, m[1]);
		ps.setString(3, m[2]);
		ps.setString(4, m[3]);

		try { 
			java.util.Date tanggalLahir = formatter.parse(m[4]);
			ps.setDate(5, new java.sql.Date(tanggalLahir.getTime()));
		} catch (Exception err){
			errors.put(baris, "Format tanggal salah");
			return;
		}
		
		ps.setInt(6, Integer.valueOf(m[5]));

		try {
			ps.executeUpdate();	
		} catch (MySQLIntegrityConstraintViolationException err){
			errors.put(baris, "NPM harus unik");
			return;
		}
		
	}

	private void tulisErrorKeFile(Map<Integer, String> daftarError, File errFile) throws Exception {
		PrintWriter out = new PrintWriter(new FileWriter(errFile));
		// tulis header
		out.println("baris,keterangan");
		for(Integer baris : daftarError.keySet()){
			out.println(baris + ","+ daftarError.get(baris));
		}
		out.flush();
		out.close();
	}

}