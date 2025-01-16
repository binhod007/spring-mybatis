package com.example.user_service.mapper;

import com.example.user_service.dto.request.UserRequestDTO;
import com.example.user_service.dto.response.UserResponseDTO;
import com.example.user_service.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Map a single User to UserResponseDTO
    @Mapping(target = "fullName", source = ".", qualifiedByName = "mapFullName")
    UserResponseDTO toUserResponseDTO(User user);

    // Map a list of Users to a list of UserResponseDTOs
    List<UserResponseDTO> toUserListResponseDTO(List<User> users);

    // Map UserRequestDTO to User model
    User toModel(UserRequestDTO userRequestDTO);

    // Custom mapping method for fullName
    @Named("mapFullName")
    default String mapFullName(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }
}





