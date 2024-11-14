package org.example.easytask;

import org.example.easytask.model.Post;
import org.example.easytask.model.User;
import org.example.easytask.service.PostService;
import org.example.easytask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = {"org.example.easytask.model"}) // Specify the package
public class Application {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runApplication() {
        return args -> {
            // Create a user
            User newUser = new User();
            newUser.setUsername("john_doe");
            newUser.setPassword("securepassword");  // In real applications, passwords should be encoded
            User savedUser = userService.saveUser(newUser);
            System.out.println("Created User: " + savedUser.getUsername());

            // Create a post
            Post newPost = new Post();
            newPost.setTitle("Hello World");
            newPost.setBody("This is my first post!");
            newPost.setAuthor(savedUser);
            Post savedPost = postService.savePost(newPost);
            System.out.println("Created Post: " + savedPost.getTitle() + " by " + savedPost.getAuthor().getUsername());
        };
    }
}
