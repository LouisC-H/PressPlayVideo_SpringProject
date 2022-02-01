package com.example.pressplayvideo;

import com.example.pressplayvideo.entities.UserEntity;
import com.example.pressplayvideo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PressPlayVideoApplication {

//    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        SpringApplication.run(PressPlayVideoApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(UserRepository userRepository){
//        return args->{
//            userRepository.save(new UserEntity("JTime", encoder.encode("Buckets"), "123 Oxford Street", "Stoke-On-Trent", "ADMIN", 1));
//        };
//    }
}
