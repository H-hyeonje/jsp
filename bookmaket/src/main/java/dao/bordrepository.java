package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;

public class bordrepository {
	public static  bordrepository getBr() {
		return br;
	}
	private bordrepository(){}
	
	private static bordrepository br=new bordrepository();
	
	PreparedStatement pstm=null;
	ResultSet rs=null;
	Connection conn= null;
	public Connection dbconn() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/BookMarketDB";
			String user="root";
			String password="1234";
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("커넥션 성공");
		} catch (Exception e) {
			System.out.println("커넥션실패"+e.getMessage());
			e.printStackTrace();
		}	
		return conn;
	}
	
	//행의 갯수를 리턴함
	public int getTotalCount() {
		
		int count =0;
		// 데이터 베이스 연결;
		conn=dbconn();
		// 쿼리 정송
		String sql="Select count(*) from board";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
		if(rs.next()) {
			count=rs.getInt(1);
		}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//resultSet
		return count;
	}
	
	
	
	//create
	public void create(Board bd) {
		//데이터 베이스 연결
		Connection conn= dbconn();
		
		//쿼리 전송
		pstm=null;
		String sql="insert into board(id,name,subject,content,regist_day,hit,ip) values(?,?,?,?,?,?,?)";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,bd.getId());
			pstm.setString(2,bd.getName());
			pstm.setString(3,bd.getSubject());
			pstm.setString(4,bd.getContent());
			pstm.setTimestamp(5,bd.getRegist_day());
			pstm.setInt(6,bd.getHit());
			pstm.setString(7,bd.getIp());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ResultSet 필요없음
	}
	
	//read All
	public ArrayList<Board> getAllBoard() {
		ArrayList<Board> arr=new ArrayList<Board>();
		
		//데이터 베이스 연결

		conn= dbconn();
		String sql="Select * from board";
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				
				Board bo=new Board();
				bo.setNum(rs.getInt("num"));
				bo.setId(rs.getString("id"));
				bo.setName(rs.getString("name"));
				bo.setSubject(rs.getString("subject"));
				bo.setContent(rs.getString("content"));
				bo.setRegist_day(rs.getTimestamp("regist_day"));
				bo.setHit(rs.getInt("hit"));
				bo.setIp(rs.getString("ip"));
				
				arr.add(bo);
				System.out.println("arr size "+arr.size());
			}
		} catch (Exception e) {
			System.out.println("arr size "+arr.size());
			e.printStackTrace();
		}
		
		
		
		//SQL전송
		
		//resultset
		return arr;
	}
}
