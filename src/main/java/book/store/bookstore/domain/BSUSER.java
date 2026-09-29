package book.store.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity (name = "users")

public class BSUSER {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column (name = "id", nullable = false, updatable = false)

    private Long id;

    @Column (name = "username", nullable = false, unique = true)
    private String username;

    @Column (name = "passwordHash", nullable = false)
    private String passwordHash; 

    @Column (name = "role", nullable = false)
    private String role;

    public BSUSER() {
    }

    public BSUSER(Long id, String username, String passwordHash, String role) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "BSUSER [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash + ", role=" + role
                + "]";
    }


    
}
