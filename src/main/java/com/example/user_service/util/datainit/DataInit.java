package com.example.user_service.util.datainit;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit {
    private final UserRepository userRepository;

//    @PostConstruct
    public void init() {

        // Clear user before inserting
        userRepository.deleteAll();

        User user1 = new User();
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setUserName("JohnDoe");
        user1.setEmail("John@sad.com");
        user1.setPassword("123456");

        User user2 = new User();
        user2.setFirstName("Jane");
        user2.setLastName("Doe");
        user2.setUserName("JaneDoe");
        user2.setEmail("jane@gmail.com");
        user2.setPassword("123456");


        userRepository.insertList(List.of(user1, user2));

    }

}
