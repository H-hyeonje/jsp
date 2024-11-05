package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class aaaa {
	public Connection conn() {
		Connection conn=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/db";
		String name="root";
		String pw="1234";
		
			conn=DriverManager.getConnection(url,name,pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

public void crate() {
	Connection conn=conn();
	PreparedStatement stmt=null;
	String sql="insert into 테이블 values()";
	try{
		stmt=conn.prepareStatement(sql);
		stmt.setString(1, sql);
	}catch(Exception e){
		System.out.println();
	}
	
}
}

