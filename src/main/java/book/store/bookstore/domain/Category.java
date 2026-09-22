package book.store.bookstore.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity 

public class Category {

    @Id 
    @GeneratedValue (strategy = GenerationType.AUTO)

        private Long categoryId;

        private String name;

        @OneToMany (cascade = CascadeType.ALL, mappedBy = "category")
        @JsonIgnoreProperties ("category")
        private List<Book> books;

        public Category() {
        }

        public Category(Long categoryId, String name) {
            this.categoryId = categoryId;
            this.name = name;
        }

        public Long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Book> getBooks() {
            return books;
        }

        public void setBooks(List<Book> books) {
            this.books = books;
        }

        @Override
        public String toString() {
            return name;
        }

       

        

}
