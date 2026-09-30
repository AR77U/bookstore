package book.store.bookstore;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import book.store.bookstore.domain.BSUSER;
import book.store.bookstore.domain.BSUSERRepository;

@Service 
public class UserDetailsServiceIMPL implements UserDetailsService {

    private final BSUSERRepository repository;

    public UserDetailsServiceIMPL(BSUSERRepository repository) {
        this.repository = repository;
    }
    

    @Override 
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        BSUSER curruser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
        AuthorityUtils.createAuthorityList(curruser.getRole()));

        return user;
    }

}
