package book.store.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import book.store.bookstore.domain.Book;
import book.store.bookstore.domain.BookRepository;
import book.store.bookstore.domain.Category;
import book.store.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	public static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean 
	public CommandLineRunner bookDemo (BookRepository repository){
		return (args) ->{
			log.info("List books ");
			repository.save(new  Book("Metsänmorkulat", "Joklas", 1987, "645984358", 45.17));
			repository.save(new  Book("Armolliset Apinat", "Jokrates", 1478, "6798457534", 67.47));

			log.info("Fetch all books");
			for (Book book: repository.findAll()){
				log.info(book.toString());
			}
		};
	}
	@Bean 
	public CommandLineRunner categoryDemo (CategoryRepository repository){
		return (args) -> {
			log.info("List of categories");
			repository.save(new Category(null, "Scifi"));
			repository.save(new Category(null, "Manga"));

			log.info("Fetch all categories");
			for (Category category: repository.findAll()){
				log.info(category.toString());
			}
		};
	}

}
