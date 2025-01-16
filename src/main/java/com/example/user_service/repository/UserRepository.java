package com.example.user_service.repository;

import com.example.user_service.model.User;
import java.util.List;

public interface UserRepository {

    User findById(Long id);
    List<User> findAll();
    void insert(User user);

    void insertList(List<User> users);
    void update(User user);
    void delete(Long id);
}
