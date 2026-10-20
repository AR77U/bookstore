package book.store.bookstore;

import book.store.bookstore.domain.Category;
import book.store.bookstore.domain.CategoryRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;



@DataJpaTest 
public class CategoryRepositoryTest {

    @Autowired 
    private CategoryRepository repository;

    @Test 
    public void createNewCateogory(){
        Category category = new Category();
        repository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test 
    public void deleteCategory() {
        Category category = repository.save(new Category());
        repository.deleteById(category.getCategoryId());
        assertThat(repository.findById(category.getCategoryId())).isEmpty();
    }

    @Test 
    public void searchCategory(){
        Category category = new Category();
        category.setName("Testikategoria");
        repository.save(category);
        List<Category> categories = repository.findByName("Testikategoria");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Testikategoria");
    }

}