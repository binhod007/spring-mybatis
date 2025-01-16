package com.example.user_service.service;

import com.example.user_service.dto.request.UserRequestDTO;
import com.example.user_service.dto.response.UserResponseDTO;
import com.example.user_service.exception.FieldAlreadyExistsException;
import com.example.user_service.exception.ResourceNotFoundException;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponseDTO findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User","id", id));
        return userMapper.toUserResponseDTO(user);
    }

    public List<UserResponseDTO> findAll() {
        if (userRepository.findAll().isEmpty()) {
            throw new ResourceNotFoundException("User", "list", null);
        }
        return userMapper.toUserListResponseDTO(userRepository.findAll());
    }

    public UserResponseDTO insert(UserRequestDTO userRequestDTO) {
        if (!Objects.isNull(userRepository.findByEmail(userRequestDTO.getEmail()))) {
            throw new FieldAlreadyExistsException("email", userRequestDTO.getEmail());
        }
        if (!Objects.isNull(userRepository.findByUserName(userRequestDTO.getUserName()))) {
            throw new FieldAlreadyExistsException("username", userRequestDTO.getUserName());
        }
        User user = userMapper.toModel(userRequestDTO);
        userRepository.insert(user);
        return userMapper.toUserResponseDTO(user);
    }

    public UserResponseDTO update(Long id, UserRequestDTO userRequestDTO) {
        if (userRepository.findById(id).isEmpty ()) {
            throw new ResourceNotFoundException("User", "id", id);
        }
        if (!Objects.isNull(userRepository.findByEmail(userRequestDTO.getEmail()))) {
            throw new FieldAlreadyExistsException("email", userRequestDTO.getEmail());
        }
        if (!Objects.isNull(userRepository.findByUserName(userRequestDTO.getUserName()))) {
            throw new FieldAlreadyExistsException("username", userRequestDTO.getUserName());
        }
        User user = userMapper.toModel(userRequestDTO);
        user.setId(id);
        userRepository.update(user);
        return userMapper.toUserResponseDTO(user);

    }

    public String delete(Long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("User", "id", id);
        }

        userRepository.delete(id);
        return String.format("User with ID %d has been successfully deleted.", id);
    }
}
