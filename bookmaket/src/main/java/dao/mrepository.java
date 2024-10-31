package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.mdto;

public class mrepository {
	private  mrepository(){}
	private static mrepository mr=new mrepository();
	public static mrepository getMr() {
		return mr;
	}
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
	//create
	public void create(mdto mt){
		//database 연결
		Connection conn=dbconn();
		//sql전송
		PreparedStatement pstm=null;
		String sql ="insert into member VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, mt.getId());
			pstm.setString(2, mt.getPassword());
			pstm.setString(3, mt.getName());
			pstm.setString(4, mt.getGender());
			pstm.setString(5, mt.getBirth());
			pstm.setString(6, mt.getMail());
			pstm.setString(7, mt.getPhone());
			pstm.setString(8, mt.getAddress());
			pstm.setTimestamp(9, mt.getRegist_day());
			System.out.println(sql);
			pstm.executeUpdate();
		} catch (SQLException e) {
			System.out.println("create 실패"+e.getMessage());
			e.printStackTrace();
		}
		finally {
			
				try {
					if(pstm!=null) {
					pstm.close();
					}
					if(conn!=null) {
						conn.close();
						}
				} 
				catch (SQLException e) {
					System.out.println("finally실패"+e.getMessage());
					e.printStackTrace();
				}
			}

		
		//resultset 전송
	}
	
	
	public mdto getUse(String id,String password) {
		mdto mt=null;
		
		//데이터 베이스 연결
		Connection conn=dbconn();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		//쿼리전송
		String sql="Select * From member where id=? and password=?";
		
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, password);
			rs=pstm.executeQuery();
			//resultset 변환 -->dto(1)
			if(rs.next()) {
				mt=new mdto();
				mt.setId(rs.getString("id"));
				mt.setPassword(rs.getString("password"));
				mt.setName(rs.getString("name"));
				mt.setGender(rs.getString("gender"));
				mt.setBirth(rs.getString("birth"));
				mt.setMail(rs.getString("mail"));
				mt.setPhone(rs.getString("phon"));
				mt.setAddress(rs.getString("address"));
				mt.setRegist_day(rs.getTimestamp("regist_day"));
			}
		} catch (SQLException e) {
			System.out.println("실패"+e.getMessage());
			e.printStackTrace();
		}
		
		return mt;
	}
}
