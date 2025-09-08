package org.jsp.lms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	
	@Autowired
	BookRepository br;

	public Book saveBook(Book b) {
		return br.save(b);
	}

	public List<Book> findAllBooks() {
		return br.findAll();
	}

	public Optional<Book> findBookById(int id) {
		return br.findById(id);
	}

	public void deleteBookById(int id) {
		br.deleteById(id);
	}
	
	
	
}