package com.digitalbook.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.entity.Book;
import com.digitalbook.service.AuthorService;

@RestController
@RequestMapping("/books")
public class AuthorController {
	@Autowired
	AuthorService authorService;
	@GetMapping
	public Iterable<Book> getBooks() {
	return authorService.getBooks();
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Integer postBook(@RequestBody Book book) {
	authorService.postBook(book);
	return book.getId();
	}
	@GetMapping("/{id}")
	public Optional<Book> getBookbyid(@PathVariable Integer id) {
	return authorService.getBookbyid(id);
	
	}
	}


