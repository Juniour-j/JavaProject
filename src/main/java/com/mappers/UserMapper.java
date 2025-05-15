package com.mappers;

import com.dto.UserDTO;
import com.models.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class UserMapper {

    public UserDTO toDTO(User user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setLastName(user.getLastName());
        dto.setRole(user.getRole());
        return dto;
    }

    public UserDTO toDTOWithPassword(User user) {
        if (user == null) return null;

        UserDTO dto = toDTO(user);
        dto.setPassword(user.getPassword());
        return dto;
    }

    public User toEntity(UserDTO dto) {
        if (dto == null) return null;

        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setLastName(dto.getLastName());
        user.setRole(dto.getRole());
        return user;
    }

    public List<UserDTO> toDTOList(List<User> users) {
        return users.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
