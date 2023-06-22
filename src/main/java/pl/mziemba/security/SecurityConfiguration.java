package pl.mziemba.security;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                // ... the rest of your authorization rules
        );
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/home", "/registration", "/logout").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
//                .logout((logout) -> logout.logoutUrl("/logout").permitAll());
                .logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/login")
                        .invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll());
//                .logout()
//                .logoutUrl("/logout") // endpoint do wylogowania
//                .logoutSuccessUrl("/login?logout") // przekierowanie po wylogowaniu
//                .invalidateHttpSession(true) // unieważnienie sesji po wylogowaniu
//                .deleteCookies("JSESSIONID") // usunięcie cookies po wylogowaniu
//                .permitAll(); // dostęp do endpointu /logout dla wszystkich

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

