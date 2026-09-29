package book.store.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BSUSERRepository extends CrudRepository<BSUSER, Long> {
   BSUSER findByUsername(String username); 
    
    
        
    

}
