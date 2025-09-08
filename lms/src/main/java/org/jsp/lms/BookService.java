package org.jsp.lms;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	BookDao dao;

	public Book saveBook(Book b) {

		Book savedBook = dao.saveBook(b);

		return savedBook;
	}

	public List<Book> findAllBooks() {

		List<Book> bl = dao.findAllBooks();

		return bl;
	}

	public Book findBookById(int id) {

		Optional<Book> optional = dao.findBookById(id);

		if (optional.isPresent()) {
			return optional.get();
		} else {

			return null;
		}

	}

	public String deleteBookById(int id) {

		dao.deleteBookById(id);

		return "Book Deleted Successfully";
	}

}