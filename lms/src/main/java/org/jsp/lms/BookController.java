package org.jsp.lms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService service;

	@PostMapping("/books")
	public Book saveBook(@RequestBody Book b) {
		return service.saveBook(b);
	}

	@GetMapping("/books")
	public List<Book> findAllBooks() {
		return service.findAllBooks();
	}

	@GetMapping("/books/{id}")
	public Book findBookById(@PathVariable int id) {
		return service.findBookById(id);
	}

	@DeleteMapping("/books/{id}")
	public String deleteBookById(@PathVariable int id) {
		return service.deleteBookById(id);
	}

}