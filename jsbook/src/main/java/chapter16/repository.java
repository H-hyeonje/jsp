package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class repository {
	private repository() {}
	
	private static repository rp=new repository();
 public static repository getinstance() {
	 return rp;
 }
 
 	public Connection dbconn()  {
 		Connection conn=null;
 		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String database="jdbc:mysql://localhost:3306/jsbookdb";
		String id="root";
		String password="1234";
		conn=DriverManager.getConnection(database,id,password);
		System.out.println("데이터 베이스 연결 완료");
 		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		return conn;
 		
 	}
 
 	
 	public void creat(dto dto) {
 		
 		Connection conn=dbconn();
 		Statement stmt = null;
		try {
			
			stmt = conn.createStatement();
			 String sql = "insert into member(id, passwd, Name) values('" + dto.getId() + "', '" + dto.getPw() + "', '" + dto.getName() + "')";
	 		stmt.executeUpdate(sql);
	 		System.out.println("성공");
		} catch (Exception e) {
			System.out.println(e.getMessage());
	 		System.out.println("실패");


		}
 	}
 	
 	public void creat2(dto dto) {
 		Connection conn=dbconn();
 		PreparedStatement pstmt=null;
 	    
 	    try {
 	        String sql = "insert into member(id, passwd, name) values(?,?,?)";
 	        pstmt = conn.prepareStatement(sql);
 	        System.out.println("입력될 값들:");
 	        System.out.println("ID: " + dto.getId());
 	        System.out.println("PW: " + dto.getPw());
 	        System.out.println("Name: " + dto.getName());
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPw());
			pstmt.setString(3,dto.getName());
 	        
 	        pstmt.executeUpdate();
 	        System.out.println("성공");
 	        
 	    } catch (Exception e) {
 	        System.out.println(e.getMessage());
 	        System.out.println("실패");
 	}
}

}
	
