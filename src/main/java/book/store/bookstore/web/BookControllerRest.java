package book.store.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import book.store.bookstore.domain.Book;
import book.store.bookstore.domain.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin 
@Controller 
@RequestMapping ("/rest")

public class BookControllerRest {

    private BookRepository bookRepository;

    public BookControllerRest(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> findAllBooksRest () {
        return (List<Book>) bookRepository.findAll();
    }
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getOneBookRest(@PathVariable (name = "id") Long bookId) {
        return bookRepository.findById(bookId);
    }
    
    
}
