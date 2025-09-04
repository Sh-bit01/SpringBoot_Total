package com.security.basicSecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Bean
    CommandLineRunner init(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("user") == null) {
                repo.save(new AppUser(null, "user", encoder.encode("password"), "USER"));
            }
            if (repo.findByUsername("admin") == null) {
                repo.save(new AppUser(null, "admin", encoder.encode("admin123"), "ADMIN"));
            }
        };
    }
}
