package book.store.bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import book.store.bookstore.domain.Book;


public interface CategoryRepository extends CrudRepository <Category, Long> {
    List <Category> findByName(String name);
}
