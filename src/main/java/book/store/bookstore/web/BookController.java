package book.store.bookstore.web;

import book.store.bookstore.domain.Book;
import book.store.bookstore.domain.BookRepository;
import book.store.bookstore.domain.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class BookController {
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
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
        model.addAttribute("category", categoryRepository.findAll());
        return "addbook";
    }
    @PostMapping("/save")
    public String savebook(Book book) {
        bookRepository.save(book);
        //TODO: process POST request
        
        return "redirect:/booklist";
    }
    
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable ("id")Long bookId, Model model) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        model.addAttribute("book", book);
        return "editbook";
    }
    @PostMapping("/edit/save")
    public String saveBookEdit(@ModelAttribute Book book) {
        bookRepository.save(book);
        //TODO: process POST request
        
        return "redirect:/booklist";
    }
    
    
    
    
    

}
