package dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import dto.memberdto;

public class memberrepository {
	//1개만 존재 해야 되므로 싱글톤으로 작성
	private static memberrepository mr=new memberrepository();
	public static memberrepository getInstance() {
		
		return mr;
	}
	
	//create
	public void member_create(memberdto dto) {
		try {
			//Step1: JDBC 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			//Step2: Connection 객체 생성
			Connection conn=null;
			String database="jdbc:mysql://localhost:3306/login_crud";
			String id="root";
			String password="1234";
			conn=DriverManager.getConnection(database,id,password);
			System.out.println("데이터 베이스 연결 완료");
			
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 오류");
		} 
		
		//Step3: SQL 전송 객체 생성 및 전송
		
		//Step4: 리턴이 있다면 ResultSet객체에 담기 -CUD는 해당없음
	}
	
	//read
	
	
	//update
	
	
	//delete
}
