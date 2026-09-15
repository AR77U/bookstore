package book.store.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import book.store.bookstore.domain.Category;
import book.store.bookstore.domain.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller 

public class CategoryController {

    private final CategoryRepository categoryRepository;
    CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
@GetMapping("/categorylist")
public String categoryList(Model model) {
    model.addAttribute("categorylist", categoryRepository.findAll());
    return "categorylist";
}
@GetMapping("/addcategory")
public String addCategory(Model model) {
    model.addAttribute("category", new  Category());
    return "addcategory";
}
@PostMapping("/savecategory")
public String saveCategory(Category category) {
    categoryRepository.save(category);
    //TODO: process POST request
    
    return "redirect:/categorylist";
}


}
