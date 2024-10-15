package dto;

import java.io.Serializable;

import dao.BookRepository;

public class Book implements Serializable{
	private static final long serialVersionUID=-4274700572038677000L;
	
	private String bookId;              //도서 id
	private String name;             	//도서명
	private int unitprice;				//가격
	private String author;				//저자
	private String description;			//설명
	private String publisher;			//출판사
	private String category;			//분류
	private long unitsInStock;			//재고개수
	private String releaseDate;			//출판일(월/년)
	private String condition;			//신제품 or 구제품 or 리퍼브제품
	
	
	
	public Book() {
	}
	public Book(String bookId, String name, int unitprice) {
		this.bookId = bookId;
		this.name = name;
		this.unitprice = unitprice;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
