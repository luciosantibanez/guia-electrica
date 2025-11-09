package com.ies.guiaelectrica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.ies.guiaelectrica.models.Usuario;
import com.ies.guiaelectrica.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication
public class GuiaElectricaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuiaElectricaApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner dataLoader(UsuarioRepository usuarioRepository,
                                        BCryptPasswordEncoder encoder,
                                        @Value("${app.admin.username}") String adminUser,
                                        @Value("${app.admin.password}") String adminPass) {
        return args -> {
            if (usuarioRepository.findByUsername(adminUser).isEmpty()) {
                Usuario u = new Usuario();
                u.setUsername(adminUser);
                u.setPassword(encoder.encode(adminPass));
                u.setRole("ADMIN");
                usuarioRepository.save(u);
                System.out.println("Admin user created: " + adminUser + ", pass: " + adminPass);
            }
        };
    }
}
