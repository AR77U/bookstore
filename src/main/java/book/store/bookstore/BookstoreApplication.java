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
	public CommandLineRunner bookDemo (BookRepository brepository, CategoryRepository crepository){
		return (args) ->{
			log.info("List books ");
			Category category1 = new Category(null, "Scifi");
			crepository.save(category1);
			Category category2 = new Category(null, "Manga");
			crepository.save(category2);
			Category category3 = new Category(null, "Thriller");
			crepository.save(category3);


			brepository.save(new  Book("Metsänmorkulat", "Joklas", 1987, "645984358", 45.17, category1));
			brepository.save(new  Book("Armolliset Apinat", "Jokrates", 1478, "6798457534", 67.47, category2));
			brepository.save(new  Book("Armottomat Rapinat", "Jokrates", 1478, "6798457534", 67.47, category3));

			log.info("Fetch all books");
			for (Book book: brepository.findAll()){
				log.info(book.toString());
			}
		};
	}


}
