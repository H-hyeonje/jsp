package dto;

import java.io.Serializable;

public class dto implements Serializable {
public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookdescription() {
		return bookdescription;
	}
	public void setBookdescription(String bookdescription) {
		this.bookdescription = bookdescription;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public long getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getBookconditione() {
		return bookconditione;
	}
	public void setBookconditione(String bookconditione) {
		this.bookconditione = bookconditione;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

private static final long serialVersionUID=-4274700572038677000L;
	
	
	
	private String bookId;              //도서 id
	private String bookname;             	//도서명
	private int unitprice;				//가격
	private String author;				//저자
	private String bookdescription;			//설명
	private String publisher;			//출판사
	private String category;			//분류
	private long unitsInStock;			//재고개수
	private String releaseDate;			//출판일(월/년)
	private String bookconditione;			//신제품 or 구제품 or 리퍼브제품
	private String fileName;			//이미지 파일명
	//장바구니 시작
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public dto() {}
	
}
