package book.store.bookstore.web;

import book.store.bookstore.domain.Book;
import book.store.bookstore.domain.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



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
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable ("id")Long bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }
    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }
    @PostMapping("/save")
    public String savebook(Book book) {
        bookRepository.save(book);
        //TODO: process POST request
        
        return "redirect:/booklist";
    }
    
    
    
    
    

}
