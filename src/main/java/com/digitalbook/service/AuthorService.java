package com.digitalbook.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.entity.Book;
import com.digitalbook.repository.AuthorRepository;
@Service
public class AuthorService {
@Autowired
 AuthorRepository authorRepository;
	public Iterable<Book> getBooks() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
		
	}
	public Book postBook(Book book) {
		// TODO Auto-generated method stub
	 	 authorRepository.save(book);
	 	 return book;
	}
	public Optional<Book> getBookbyid(Integer id) {
		// TODO Auto-generated method stub
		return authorRepository.findById(id);
	}

}
