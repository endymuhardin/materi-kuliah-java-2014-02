package com.muhardin.endy.belajar;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception 
    {
        System.out.println( "Hello World!" );
		
		// 0. Variabel untuk koneksi
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost/belajarjava";
		String dbUser = "root";
		String dbPass = "";
		
		// 1. Aktivasi driver database
		Class.forName(dbDriver);
		
		// 2. Connect ke database
		Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		
		// 3. Jalankan query
		String sql = "insert into anggota (nama,email) ";
		sql += "values (?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,"Endy Muhardin");
		ps.setString(2,"endy.muhardin@gmail.com");
		ps.executeUpdate();
		
		String sql2 = "select *from anggota";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ResultSet rs = ps2.executeQuery();
		
		while(rs.next()){
			System.out.println("ID : "+rs.getInt("id"));
			System.out.println("Nama : "+rs.getString("nama"));
			System.out.println("Email : "+rs.getString("email"));
		}
		
		
		rs.close();
		
		// 3. Disconnect
		conn.close();
 
 }
}
