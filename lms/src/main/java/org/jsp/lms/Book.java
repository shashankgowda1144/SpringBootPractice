package org.jsp.lms;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String author;
	private double price;
	private int qty;
	private String des;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Book(int id, String title, String author, double price, int qty, String des) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.qty = qty;
		this.des = des;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", qty=" + qty
				+ ", des=" + des + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, des, id, price, qty, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(des, other.des) && id == other.id
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && qty == other.qty
				&& Objects.equals(title, other.title);
	}

}