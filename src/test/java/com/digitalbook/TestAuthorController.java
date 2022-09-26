package com.digitalbook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.digitalbook.DTO.BuyBookDTO;
import com.digitalbook.controller.AuthorController;
import com.digitalbook.entity.Book;
import com.digitalbook.entity.BuyBook;
import com.digitalbook.service.AuthorService;

@ExtendWith(MockitoExtension.class)
public class TestAuthorController {
	@Mock
	AuthorService authorService;
	@InjectMocks
	AuthorController authorController;

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
		Mockito.when(authorService.getBooks()).thenReturn(book);
		Iterable<Book> getbooks = authorController.getBooks();
		assertEquals(book, getbooks);
	}

	@Test
	public void testPostBook() {
		Book digitalbook = new Book();
		digitalbook.setId(18);
		digitalbook.setTitle("yuvi");
		digitalbook.setCategory("cricket");
		digitalbook.setPrice(900);
		digitalbook.setPublisher("India");
		digitalbook.setPublisheddate("2006-09-10");
		digitalbook.setAuthor("Rizzu");
		Mockito.when(authorService.postBook(digitalbook)).thenReturn(digitalbook);
		Integer postbookId = authorController.postBook(digitalbook);
		assertEquals(18, postbookId);
	}

	@Test
	public void testgetBookbyid() throws Exception {
		Optional<Book> digitalbook = Optional.of(new Book());
		Mockito.when(authorService.getBookbyid(18)).thenReturn(digitalbook);
		Optional<Book> Bookbyid = authorController.getBookbyid(18);
		assertEquals(digitalbook, Bookbyid);
	}
	
//	@Test
//	public void testdelete( ) {
//		Book digitalbook = new Book();
//		Mockito.when(authorService.delete(18)).thenReturn(digitalbook);
//		
//	}
	@Test
	public void buyBook() {
		BuyBookDTO buyBookDTO	= new BuyBookDTO();
		buyBookDTO.setBookId(1);
		buyBookDTO.setUsername("trilok");
		buyBookDTO.setUseremail("trilok@gmail.com");
		String response ="success";
		Mockito.when(authorService.buyBook(buyBookDTO)).thenReturn(response);
		String  buyBookid = authorController.buyBook(buyBookDTO);
		assertEquals(response, buyBookid);
}
	@Test
	public void buyBooks() {
		BuyBookDTO buyBookDTO	= new BuyBookDTO();
		buyBookDTO.setBookId(1);
		buyBookDTO.setUsername("trilok");
		buyBookDTO.setUseremail("trilok@gmail.com");
		String response ="failure";
		Mockito.when(authorService.buyBook(buyBookDTO)).thenReturn(response);
		String  buyBookid = authorController.buyBook(buyBookDTO);
		assertEquals(response, buyBookid);
}
	
	@Test
	public void testgetBuyBook() {
		String emailid="trilok@gmail.com";
		BuyBook buyBook	= new BuyBook();
		buyBook.setId(1);
		buyBook.setBookId(1);
		buyBook.setUserId(1);
		List<BuyBook> arraylist = new ArrayList();
		arraylist.add(buyBook);
		Mockito.when(authorService.getBuyBook(emailid)).thenReturn(arraylist);
		List<BuyBook> buybookid = authorController.getBuyBook(emailid);
		assertEquals(arraylist, buybookid);				
		}
	@Test
	public void testreadABook() {
		int id=1;
		String emailid="trilok@gmail.com";
		Optional<Book> books = Optional.of(new Book());
		Mockito.when(authorService.readABook(emailid,id)).thenReturn(books);
		Optional<Book> buybookid = authorController.readABook(emailid,id);
		assertEquals(books, buybookid);				
		}
}