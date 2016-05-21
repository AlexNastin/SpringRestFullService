package spring.restfullservice.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.restfullservice.example.bean.AjaxResponse;
import spring.restfullservice.example.bean.Book;

@RestController
public class RestControllerExample {

	private List<Book> books = new ArrayList<Book>();
	private List<String> names = new ArrayList<String>();
	private List<String> authors = new ArrayList<String>();

	@PostConstruct
	private void initData() {
		Random random = new Random();
		names.add("О всё видавшем");
		names.add("Сага о Ньяле");
		names.add("Декамерон");
		names.add("Грозовой перевал");
		names.add("Энеида");
		names.add("Миссис Дэллоуэй");
		names.add("Сто лет одиночества");
		names.add("Тропы по большому сертану");
		names.add("Мёртвые души");
		names.add("Илиада");
		names.add("Жак-фаталист и его хозяин");
		authors.add("Фёдор Достоевский");
		authors.add("Джеймс Джойс");
		authors.add("Дени Дидро");
		authors.add("Чарльз Диккенс");
		authors.add("Данте Алигьери");
		authors.add("Дэвид Герберт Лоуренс");
		authors.add("Джалаладдин Руми");
		authors.add("Луи-Фердинанд Селин");
		authors.add("Лев Толстой");
		authors.add("Уильям Шекспир");
		authors.add("Маргерит Юрсенар");
		for (int i = 0; i < 100; i++) {
			Book book = new Book();
			book.setIdBook(random.nextInt(1000));
			book.setName(names.get(random.nextInt(10)));
			book.setAuthor(authors.get(random.nextInt(10)));
			long time = random.nextLong();
			if (time < 0) {
				time *= (-1);
			}
			book.setDataPublishing(new Date(time));
			books.add(book);
		}
	}

	@RequestMapping(value = "/library", method = RequestMethod.GET)
	public List<Book> library() {
		System.out.println("Library");
		return books;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AjaxResponse save(@RequestBody Book book) {
		System.out.println("Save book: " + book);
		books.add(book);
		AjaxResponse ajaxResponse = new AjaxResponse();
		ajaxResponse.setCode("200");
		return ajaxResponse;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Book get(@PathVariable int id) {
		System.out.println("Get book ID: " + id);
		for (int i = 0; i < books.size(); i++) {
			if (id == books.get(i).getIdBook()) {
				return books.get(i);
			}
		}
		return null;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public AjaxResponse delete(@PathVariable int id) {
		AjaxResponse ajaxResponse = new AjaxResponse();
		ajaxResponse.setCode("400");
		System.out.println("Delete book ID: " + id);
		for (int i = 0; i < books.size(); i++) {
			if (id == books.get(i).getIdBook()) {
				books.remove(i);
				ajaxResponse.setCode("200");
			} 
		}
		return ajaxResponse;
	}
}
