package com.blog_app.service.impl;

import com.blog_app.dto.UserDto;
import com.blog_app.entity.Role;
import com.blog_app.entity.User;
import com.blog_app.exception.ResourceNotFoundException;
import com.blog_app.repository.UserRepository;
import com.blog_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private  final UserRepository userRepository;
    private  final PasswordEncoder passwordEncoder;
    private  final ModelMapper modelMapper;
    @Override
    public UserDto registerUser(UserDto userDto) {
        //
        User user = modelMapper.map(userDto, User.class);

        validateUser(user);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public void delete(Long userId) {
        var article = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        userRepository.delete(article);

    }

    private void validateUser(User user) {
        User user1 = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (user1 != null) {
            throw new ResourceNotFoundException("User with email " + user.getEmail() + " already exists");
        }
    }
}
