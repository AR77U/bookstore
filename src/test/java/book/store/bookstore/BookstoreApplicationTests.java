package book.store.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import book.store.bookstore.web.BookController;
import book.store.bookstore.web.BookControllerRest;
import book.store.bookstore.web.CategoryController;

@SpringBootTest
class BookstoreApplicationTests {

	@Autowired 
	private BookController bookController;

	@Autowired 
	private BookControllerRest bookControllerRest;

	@Autowired 
	private CategoryController categoryController;

	@Test
	public void contextLoads() {
		assertThat(bookController).isNotNull();
	}

	@Test 
	public void BookControllerRestLoads() {
		assertThat(bookControllerRest).isNotNull();
	}

	@Test 
	public void CategoryControllerLoads() {
		assertThat(categoryController).isNotNull();
	}

}
