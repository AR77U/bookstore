package book.store.bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
@EnableMethodSecurity ( securedEnabled = true)


public class SecurityConfig {


    @Bean 
    public SecurityFilterChain configure(HttpSecurity http)  throws Exception {
        http
        .authorizeHttpRequests(authorize -> authorize
        .requestMatchers("/css/**").permitAll() // Sallii css vaikka kirjauduttuna ulos
        .anyRequest().authenticated()
        ) 
        .formLogin( formlogin -> formlogin
            .defaultSuccessUrl("/booklist", true)
            .permitAll()
        )
        .logout(logout -> logout
        .permitAll()
    );
    return http.build();
        
    }
  @Bean 
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
   
}
