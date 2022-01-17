package com.onurkus.fourthhomework.service;

import com.onurkus.fourthhomework.converter.UserMapper;
import com.onurkus.fourthhomework.dto.userdto.UserDto;
import com.onurkus.fourthhomework.dto.userdto.UserSaveDto;
import com.onurkus.fourthhomework.entity.User;
import com.onurkus.fourthhomework.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityService userEntityService;

   public List<UserDto> findAll() {

        List<User> userList = userEntityService.findAll();

        List<UserDto> userDtoList = UserMapper.INSTANCE.convertToUserDtoList(userList);

        return userDtoList;
    }

    public UserDto findById(Long id) {

        User user = findUserById(id);

        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);

        return userDto;
    }


    public UserDto save(UserSaveDto userSaveDto) {

        User user = UserMapper.INSTANCE.convertToUserSave(userSaveDto);

        user = userEntityService.save(user);

        UserDto userDto = UserMapper.INSTANCE.convertToUserDto(user);

        return userDto;
    }

    public void delete(Long id) {

        User user = findUserById(id);

        userEntityService.delete(user);
    }

    private User findUserById(Long id) {
        Optional<User> optionalUser = userEntityService.findById(id);

        User user;
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        } else {
            throw new RuntimeException("User not found!");
        }
        return user;
    }
}

