package com.muhardin.endy.belajar.csv;

import org.junit.*;

import java.sql.*;
import java.io.File;

public class ImportMahasiswaTest {

	private Connection conn;

	@Before
	public void connect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager
			.getConnection("jdbc:mysql://localhost/belajar", "belajar", "java");

		conn.createStatement().executeUpdate("delete from mahasiswa");
	}

	public void disconnect() throws Exception {
		conn.close();
	}

	@Test
	public void testImportNormal() throws Exception {
		
		ImportMahasiswa importer = new ImportMahasiswa(conn);
		File input = new File("src/main/resources/mahasiswa.csv");
		File error = new File("target/import-error.txt");

		importer.importFile(input, true, error);
	}

	@Test
	public void testImportInvalid() throws Exception {
		ImportMahasiswa importer = new ImportMahasiswa(conn);
		File f = new File("src/main/resources/mahasiswa-invalid.csv");
		File error = new File("target/import-error.txt");
		importer.importFile(f, true, error);
	}

}