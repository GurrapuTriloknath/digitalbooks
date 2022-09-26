package com.digitalbook.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalbook.DTO.BuyBookDTO;
import com.digitalbook.entity.Book;
import com.digitalbook.entity.BuyBook;
import com.digitalbook.service.AuthorService;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class AuthorController extends BaseController {
	@Autowired
	AuthorService authorService;

	/* Delete method */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		authorService.delete(id);
	}

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

	@PostMapping("/buy")
	public String buyBook(@RequestBody BuyBookDTO buyBookDTO) {
		return authorService.buyBook(buyBookDTO);
	}

	@PostMapping("/readers/{emailId}/books")
	public List<BuyBook> getBuyBook(@PathVariable String emailId) {
		return authorService.getBuyBook(emailId);

	}

	@PostMapping("/readers/{emailId}/books/{bookId}")
	public Optional<Book> readABook(@PathVariable String emailId, @PathVariable int bookId) {
		return authorService.readABook(emailId, bookId);

	}
}
