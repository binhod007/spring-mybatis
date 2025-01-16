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

    @PostConstruct
    public void init() {
        User user1 = new User();
        user1.setName("John Doe");
        user1.setEmail("John@sad.com");

        User user2 = new User();
        user2.setName("Jane Doe");
        user2.setEmail("asdsad@asdsad.com");

        userRepository.insertList(List.of(user1, user2));

    }

}
