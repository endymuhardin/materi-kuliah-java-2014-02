package com.muhardin.endy.belajar.csv;

import org.junit.Test;

import java.sql.*;
import java.io.File;

public class ImportMahasiswaTest {

	@Test
	public void testImportNormal() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager
			.getConnection("jdbc:mysql://localhost/belajar", "belajar", "java");

		ImportMahasiswa importer = new ImportMahasiswa(conn);
		File f = new File("src/main/resources/mahasiswa.csv");

		importer.importFile(f, true);
	}

}