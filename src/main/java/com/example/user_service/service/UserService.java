package com.example.user_service.service;

import com.example.user_service.dto.request.UserRequestDTO;
import com.example.user_service.dto.response.UserResponseDTO;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id);
        return userMapper.toUserResponseDTO(user);
    }

    public List<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toUserResponseDTO)
                .collect(Collectors.toList());
    }

    public UserResponseDTO insert(UserRequestDTO userRequestDTO) {
        User user = userMapper.toModel(userRequestDTO);
        userRepository.insert(user);
        return userMapper.toUserResponseDTO(user);
    }

    public UserResponseDTO update(Long id, UserRequestDTO userRequestDTO) {

        User user = userMapper.toModel(userRequestDTO);
        user.setId(id);
        userRepository.update(user);
        return userMapper.toUserResponseDTO(user);
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }
}
