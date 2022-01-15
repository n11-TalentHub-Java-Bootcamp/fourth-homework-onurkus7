package com.onurkus.fourthhomework.service;

import com.onurkus.fourthhomework.converter.UserMapper;
import com.onurkus.fourthhomework.dto.userdto.UserDto;
import com.onurkus.fourthhomework.dto.userdto.UserSaveDto;
import com.onurkus.fourthhomework.entity.User;
import com.onurkus.fourthhomework.service.entityservice.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityService userEntityService;

    public UserDto save(UserSaveDto userSaveDto) {

        User user = UserMapper.INSTANCE.convertToUserSaveDto(userSaveDto);

        user = userEntityService.save(user);

        UserDto userDto = UserMapper.INSTANCE.convertToUsrUserDtoList(user);

        return userDto;
    }
}

