package spring.restfullservice.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.restfullservice.example.bean.AjaxResponse;
import spring.restfullservice.example.bean.Book;

@RestController
public class RestControllerExample {

	private List<Book> books = new ArrayList<Book>();

	@PostConstruct
	private void initDataForTesting() {
		Book book1 = new Book();
		book1.setIdBook(1);
		book1.setName("AAAA");
		book1.setProvider("X1");
		Book book2 = new Book();
		book2.setIdBook(2);
		book2.setName("BBBB");
		book2.setProvider("X2");
		Book book3 = new Book();
		book3.setIdBook(3);
		book3.setName("CCCC");
		book3.setProvider("X3");
		Book book4 = new Book();
		book4.setIdBook(4);
		book4.setName("DDDD");
		book4.setProvider("X4");
		List<Book> list = new ArrayList<Book>();
		list.add(book1);
		list.add(book2);
		list.add(book3);
		list.add(book4);
		list.add(book2);
		books.addAll(list);
	}

	@RequestMapping(value = "/library", method = RequestMethod.GET)
	public List<Book> library() {
		System.out.println("library");
		return books;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AjaxResponse save(@RequestBody Book book) {
		System.out.println(book);
		book.setProvider("X");
		books.add(book);
		System.out.println("SAVE");
		AjaxResponse ajaxResponse = new AjaxResponse();
		ajaxResponse.setCode("200");
		return ajaxResponse;
	}

}
