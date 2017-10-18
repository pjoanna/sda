package sda.spring.map;

import sda.spring.model.User;
import sda.spring.model.UserDto;

public class UserMapping {
    public static User mapToUser(UserDto userDto) {
        User entity = new User();
        entity.setUsername(userDto.getUsername());
        entity.setPassword(userDto.getPassword());
        entity.setFirstname(userDto.getFirstname());
        entity.setLastname(userDto.getLastname());
        entity.setAddress(userDto.getAddress());
        entity.setEmail(userDto.getEmail());
        entity.setPhone(userDto.getPhone());

        return entity;
    }

    public static UserDto mapToUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setFirstname(user.getFirstname());
        dto.setLastname(user.getLastname());
        dto.setAddress(user.getAddress());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }
}
