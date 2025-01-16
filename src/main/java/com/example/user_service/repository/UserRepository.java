package com.example.user_service.repository;

import com.example.user_service.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Long id);
    List<User> findAll();
    void insert(User user);
    User findByEmail(String email);
    User findByUserName(String userName);

    void insertList(List<User> users);
    void update(User user);
    void delete(Long id);
    void deleteAll();

}
