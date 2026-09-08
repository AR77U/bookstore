package book.store.bookstore.web;

import book.store.bookstore.domain.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BookController {
    private final BookRepository bookRepository;
    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/index")
    public String getBookName() {
        return "index";
    }
    @GetMapping("/booklist")
    public String bookList(Model model) {
        model.addAttribute("booklist" , bookRepository.findAll());
        return "booklist";
    }
    
    

}
