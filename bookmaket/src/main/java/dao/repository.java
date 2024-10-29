package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import dto.dto;

public class repository {
	//생성자
	private repository() {}
	//싱글톤
	private static repository rt=new repository();
	//싱글톤
	public static repository getInstance() {
		return rt;
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
	
	//book 객체 묶음
	public ArrayList<dto> allread(){
		ResultSet rs=null;
		ArrayList<dto> arr=new ArrayList<dto>();
		Connection conn=dbconn();
		PreparedStatement pstm=null;
		try {
			String sql="select * from book";
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()) {
				dto dto=new dto();
				String bookid=rs.getString("bookid");
				String bookname=rs.getString("bookname");
				int unitprice=rs.getInt("unitprice");
				String author=rs.getString("author");
				String bookdescription=rs.getString("bookdescription");
				String publisher=rs.getString("publisher");
				String category=rs.getString("category");
				long unitsInStock=rs.getLong("unitsInStock");
				String releaseDate=rs.getString("releaseDate");
				String bookcondition=rs.getString("bookcondition");
				String fileName=rs.getString("fileName");
				
				dto.setBookId(bookid);
				dto.setBookname(bookname);
				dto.setUnitprice(unitprice);
				dto.setAuthor(author);
				dto.setBookdescription(bookdescription);
				dto.setPublisher(publisher);
				dto.setCategory(category);
				dto.setUnitsInStock(unitsInStock);
				dto.setReleaseDate(releaseDate);
				dto.setBookconditione(bookcondition);
				dto.setFileName(fileName);
				
				arr.add(dto);}
			System.out.println("allread 성공");
		} catch (SQLException e) {
			System.out.println("allread 실패"+e.getMessage());
			e.printStackTrace();
		} finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstm != null) pstm.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		return arr;
		
	}
	
	public dto read(String bookid1) {
		Connection conn=dbconn();
		ResultSet rs=null;
		PreparedStatement psmt=null;
		String sql="SELECT * FROM book WHERE bookId = ?";
		dto dto=new dto();
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, bookid1);
			rs=psmt.executeQuery();
			while(rs.next()) {
				String bookid=rs.getString("bookid");
				String bookname=rs.getString("bookname");
				int unitprice=rs.getInt("unitprice");
				String author=rs.getString("author");
				String bookdescription=rs.getString("bookdescription");
				String publisher=rs.getString("publisher");
				String category=rs.getString("category");
				long unitsInStock=rs.getLong("unitsInStock");
				String releaseDate=rs.getString("releaseDate");
				String bookcondition=rs.getString("bookcondition");
				String fileName=rs.getString("fileName");
				
				dto.setBookId(bookid);
				dto.setBookname(bookname);
				dto.setUnitprice(unitprice);
				dto.setAuthor(author);
				dto.setBookdescription(bookdescription);
				dto.setPublisher(publisher);
				dto.setCategory(category);
				dto.setUnitsInStock(unitsInStock);
				dto.setReleaseDate(releaseDate);
				dto.setBookconditione(bookcondition);
				dto.setFileName(fileName);
				
			}
			System.out.println("한개 성공");
		} catch (SQLException e) {
			System.out.println("한개 실패"+e.getMessage());
			e.printStackTrace();
		}finally {
			
				try {
				if(rs!=null) {
					rs.close();
					}
				if(psmt!=null) {
					psmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

		}
		
		return dto;
	}
	public void create(dto dto) {
		Connection conn=dbconn();
		PreparedStatement pstm=null;
		try {
			String sql="insert into book values(?,?,?,?,?,?,?,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, dto.getBookId());
			pstm.setString(2, dto.getBookname());
			pstm.setInt(3, dto.getUnitprice());
			pstm.setString(4, dto.getAuthor());
			pstm.setString(5, dto.getBookdescription());
			pstm.setString(6, dto.getPublisher());
			pstm.setString(7, dto.getCategory());
			pstm.setLong(8, dto.getUnitsInStock());
			pstm.setString(9, dto.getReleaseDate());
			pstm.setString(10, dto.getBookconditione());
			pstm.setString(11, dto.getFileName());
			pstm.executeUpdate();
			System.out.println("create성공");
		} catch (SQLException e) {
			System.out.println("create 실패"+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}
	
	
	public void del(String bookid) {
		Connection conn=dbconn();
		PreparedStatement psmt=null;
		String sql="delete from book where ?";
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, bookid);
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			if(psmt!=null) {
				
					psmt.close();}
			if(conn!=null) {
				conn.close();
			}
				} catch (Exception e) {
		
					e.printStackTrace();
				}
			}
		}
		
		
		
	}
	


