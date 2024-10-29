package chapter16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class repostitory2 {
	private repostitory2() {}
	
	private static repostitory2 rp2=new repostitory2();
	
	public static repostitory2 getinstance() {
		return rp2;
	}
	public Connection conn() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jsbookdb";
			String user="root";
			String pw="1234";
			conn=DriverManager.getConnection(url,user,pw);
			System.out.println("연결성공");
			
		} catch (Exception e) {
			System.out.println("연결실패"+e.getMessage());
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	public void creat(dto dto) {
		Connection conn=conn();
		PreparedStatement pstm=null;
		try {
			String sql="insert into member values(?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,dto.getId());
			pstm.setString(2,dto.getPw());
			pstm.setString(3,dto.getName());
			System.out.println(pstm);
			System.out.println(dto.getId());
			pstm.executeUpdate();
			System.out.println("성공");
		} catch (SQLException e) {
			System.out.println("실패"+e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<dto> read() {
		ArrayList<dto> arr=new ArrayList();
		Connection conn=conn();
		dto dto=new dto();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		String sql="select *from member";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				String id=rs.getString("id");
				String pw=rs.getString("pw");
				String name=rs.getString("name");
				dto.setId(id);
				dto.setPw(pw);
				dto.setName(name);
				arr.add(dto);
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		
		return arr;
	}
	
}
