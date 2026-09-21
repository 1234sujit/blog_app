package com.blog_app.service;

import com.blog_app.dto.UserDto;

public interface UserService {

    UserDto registerUser(UserDto userDto);
    void delete(Long userId);
}
