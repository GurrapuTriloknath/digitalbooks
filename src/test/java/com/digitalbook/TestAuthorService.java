package com.digitalbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import com.digitalbook.DTO.BuyBookDTO;
import com.digitalbook.entity.Book;
import com.digitalbook.entity.BuyBook;
import com.digitalbook.repository.AuthorRepository;
import com.digitalbook.repository.BuyBookRepository;
import com.digitalbook.service.AuthorService;
import com.digitalbook.springjwt.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class TestAuthorService {
	@InjectMocks
	AuthorService authorService;
	@Mock
	AuthorRepository authorRepository;
	@Mock
	UserRepository userRepository;
    @Mock
    BuyBookRepository buyBookRepository;

	@Test
	public void testgetBooks() throws Exception {
		List<Book> book = new ArrayList<>();
		Book digitalbook = new Book();
		digitalbook.setId(18);
		digitalbook.setTitle("Virat");
		digitalbook.setCategory("cricket");
		digitalbook.setPrice(500);
		digitalbook.setPublisher("India");
		digitalbook.setPublisheddate("2008-08-18");
		digitalbook.setAuthor("Rizzu");
		book.add(digitalbook);
		when(authorRepository.findAll()).thenReturn(book);
		Iterable<Book> getbooks = authorService.getBooks();
		assertEquals(book, getbooks);
	}
	
    @Test
    public void testPostBook() {
    	Book digitalbook = new Book();
    	digitalbook.setId(18);
		digitalbook.setTitle("Virat");
		digitalbook.setCategory("cricket");
		digitalbook.setPrice(500);
		digitalbook.setPublisher("India");
		digitalbook.setPublisheddate("2008-08-18");
		digitalbook.setAuthor("Rizzu");
		when(authorRepository.save(digitalbook)).thenReturn(digitalbook);
		authorService.postBook(digitalbook);
		assertEquals(18, digitalbook.getId());
    }
    
    @Test
    public void testgetBookbyid() throws Exception{
    	Optional<Book> digitalbook = Optional.of(new Book());
    	Mockito.when(authorRepository.findById(18)).thenReturn(digitalbook);
    	Optional<Book> Bookbyid = authorService.getBookbyid(18);
        assertEquals(digitalbook, Bookbyid);
    }
    
    @Test
    public void buyBook() {
    	BuyBookDTO buyBook	= new BuyBookDTO();
    	buyBook.setBookId(1);
    	buyBook.setUsername("trilok");
    	buyBook.setUseremail("trilok@gmail.com");
		Book book = new Book();
		String response="success";
		Optional<Book> option = Optional.of(book);		
		Mockito.when(authorRepository.findById(buyBook.getBookId())).thenReturn(option);
		String postbookId = authorService.buyBook(buyBook);
		assertEquals(response, postbookId);
    }	
}
