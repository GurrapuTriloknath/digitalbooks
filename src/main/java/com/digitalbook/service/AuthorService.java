package com.digitalbook.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalbook.DTO.BuyBookDTO;
import com.digitalbook.entity.Book;
import com.digitalbook.entity.BuyBook;
import com.digitalbook.repository.AuthorRepository;
import com.digitalbook.repository.BuyBookRepository;
import com.digitalbook.springjwt.models.User;
import com.digitalbook.springjwt.repository.UserRepository;

@Service
public class AuthorService {
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	BuyBookRepository buyBookRepository;

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

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		authorRepository.deleteById(id);
	}

	public String buyBook(BuyBookDTO buyBookDTO) {
		String Status = "failure";
		Optional<Book> book = authorRepository.findById(buyBookDTO.getBookId());
		if (book.get() != null) {
			int getuserId = userRepository.getuserId(buyBookDTO.getUsername(), buyBookDTO.getUseremail());
			BuyBook buyBook = new BuyBook();
			buyBook.setBookId(buyBookDTO.getBookId());
			buyBook.setUserId(getuserId);
			buyBookRepository.save(buyBook);
			Status = "success";
		} else {
			Status = "failure";
		}

		// TODO Auto-generated method stub
		return Status;
	}

	public List<BuyBook> getBuyBook(String emailId) {

		User user = userRepository.findByEmail(emailId);
		List<BuyBook> buyedBook = buyBookRepository.findByUserId(user.getId());
		return buyedBook;
	}

	public Optional<Book> readABook(String emailId, int bookId) {
		User user = userRepository.findByEmail(emailId);
		if (user != null) {
			Optional<Book> book = authorRepository.findById(bookId);
			// TODO Auto-generated method stub
			return book;
		}
		Optional<Book> option = Optional.empty();
		return option;

	}

}
