package com.pauloten.workshopmongodbunity.Config;

import com.pauloten.workshopmongodbunity.Domain.User;
import com.pauloten.workshopmongodbunity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User jack = new User(null, "Jack Black", "jack@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob,jack));
    }
}
