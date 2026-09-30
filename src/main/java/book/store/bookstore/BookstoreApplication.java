package book.store.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import book.store.bookstore.domain.BSUSER;
import book.store.bookstore.domain.BSUSERRepository;
import book.store.bookstore.domain.Book;
import book.store.bookstore.domain.BookRepository;
import book.store.bookstore.domain.Category;
import book.store.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private final BSUSERRepository BSUSERRepository;
    public static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

    BookstoreApplication(BSUSERRepository BSUSERRepository) {
        this.BSUSERRepository = BSUSERRepository;
    }

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
			Category category4 = new Category(null, "Romance");
			crepository.save(category4);


			brepository.save(new  Book("Metsänmorkulat", "Joklas", 1987, "645984358", 45.17, category1));
			brepository.save(new  Book("Armolliset Apinat", "Jokrates", 1478, "6798457534", 67.47, category2));
			brepository.save(new  Book("Armottomat Rapinat", "Jokrates", 1478, "6798457534", 67.47, category3));

			BSUSER user1 = new  BSUSER(null, "user1", "$2a$10$x6dSp1eOcGfqc/xd65kWX.pg56aKciCe5NdtvRQsJ8sj0l2L9mcUm", "USER"); //PASSWORD: yordle123
			BSUSER user2 = new  BSUSER(null, "user2", "$2a$10$F1WabYS4n1kxuUTTqZJKuuQXttJOgiQZp.DlOtA142sFVCUnxJWUK", "ADMIN"); //PASSWORD:yordle47

			BSUSERRepository.save(user1);
			BSUSERRepository.save(user2);

			log.info("Fetch all books");
			for (Book book: brepository.findAll()){
				log.info(book.toString());
			}
		};
	}


}
