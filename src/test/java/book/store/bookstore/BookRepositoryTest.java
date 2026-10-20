package book.store.bookstore;

import book.store.bookstore.domain.Book;
import book.store.bookstore.domain.BookRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;



@DataJpaTest 
public class BookRepositoryTest {

    @Autowired 
    private BookRepository repository;

    @Test 
    public void createNewBook(){
        Book book = new Book();
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test 
    public void deleteBook() {
        Book book = repository.save(new Book());
        repository.deleteById(book.getId());
        assertThat(repository.findById(book.getId())).isEmpty();
    }

    @Test 
    public void searchBook(){
        Book book = new Book();
        book.setTitle("Testikirja");
        repository.save(book);
        List<Book> books = repository.findByTitle("Testikirja");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Testikirja");
    }

}
 