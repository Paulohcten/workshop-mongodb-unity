package com.pauloten.workshopmongodbunity.Config;

import com.pauloten.workshopmongodbunity.Domain.Post;
import com.pauloten.workshopmongodbunity.Domain.User;
import com.pauloten.workshopmongodbunity.Repository.PostRepository;
import com.pauloten.workshopmongodbunity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        User jack = new User(null, "Jack Black", "jack@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Las Vegas, here I go!", "FINALLY some Vacations, I'm Going to travel",jack);
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Good Morning", "I'm super happy for some reason!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob,jack));
        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
