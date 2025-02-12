package com.springboot.dto.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import java.util.List;
import com.springboot.dto.dto.UserDTO;
import com.springboot.dto.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Basic mapping
    @Mapping(target = "name", expression = "java(formatName(user.getName()))")
    UserDTO userToUserDTO(User user);

    // Mapping back from DTO, setting email to a default value
    @Mapping(target = "email", expression = "java(getDefaultEmail())")
    User userDTOToUser(UserDTO userDTO);

    // Convert List<User> to List<UserDTO>
    List<UserDTO> userListToUserDTOList(List<User> users);

    // Custom method for name formatting
    default String formatName(String name) {
        return name != null ? name.toUpperCase() : "UNKNOWN";
    }

    // Default email for unmapped field
    default String getDefaultEmail() {
        return "default@example.com";
    }

    // Post-processing after mapping
    @AfterMapping
    default void setDefaultEmail(@MappingTarget User user) {
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            user.setEmail("no-email@default.com");
        }
    }
}
