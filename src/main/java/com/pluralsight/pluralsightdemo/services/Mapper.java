package com.pluralsight.pluralsightdemo.services;

import com.pluralsight.pluralsightdemo.models.User;
import com.pluralsight.pluralsightdemo.models.UserDto;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        return userDto;
    }
}
