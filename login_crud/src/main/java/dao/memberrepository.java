package dao;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.*;

import dto.memberdto;

public class memberrepository {
	//1개만 존재 해야 되므로 싱글톤으로 작성
	private static memberrepository mr=new memberrepository();
	public static memberrepository getInstance() {
		
		return mr;
	}
	
	//Step2: Connection 객체 생성
	private Connection DBconn() throws Exception  {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=null;
		String database="jdbc:mysql://localhost:3306/login_crud";
		String id="root";
		String password="1234";
		conn=DriverManager.getConnection(database,id,password);
		System.out.println("데이터 베이스 연결 완료");
		return conn;
	}
	
	//create
	public void member_create(memberdto dto)  {
		try {

			Connection conn=DBconn();
			//Step3: SQL 전송 객체 생성 및 전송
			Statement stmt= conn.createStatement();
			String userid=dto.getId();
			String pw=dto.getPw();
			int age=dto.getAge();
			//insert into memver values("admin","1234",7)
			//insert into memver values('userid','pw',7)
			//"insert into memver values('"
			// userid +"','"+pw
			// pw +"',"+age
			// age +")"
			String sql="insert into member values('"+userid+"','"+pw+"',"+age+" )";
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결 오류");
		} 
		
		
		
		
		//Step4: 리턴이 있다면 ResultSet객체에 담기 -CUD는 해당없음
	}
	
	//read
	public ArrayList<memberdto> getAllmember() throws Exception{
		
			ArrayList<memberdto> arr=new ArrayList<memberdto>();
			ResultSet rs=null;
			try {
				Connection conn=DBconn();
				Statement stmt=conn.createStatement();
				String sql="Select * from member ORDER BY id desc";
			
				rs=stmt.executeQuery(sql);
				while(rs.next()) {
									//컬럼명
					String id=rs.getString("id");
					String pw=rs.getString("pw");
					int age=rs.getInt("age");
					memberdto dto=new memberdto();
					dto.setId(id);
					dto.setPw(pw);
					dto.setAge(age);
				
					arr.add(dto);
				}
			
			} catch (Exception e) {

				e.printStackTrace();
			}
		return arr;
	}
	
	//update
	
	
	//delete
	public void deleteuser(String id) {
		try {
			//Step 1 db연결
			Connection conn=DBconn();
			//Step 2 Query 전송 및 실행
			Statement stmt=conn.createStatement();
			String sql="delete from member where id='"+id+"'";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
