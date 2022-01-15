package com.onurkus.fourthhomework.controller;

import com.onurkus.fourthhomework.dto.userdto.UserDto;
import com.onurkus.fourthhomework.dto.userdto.UserSaveDto;
import com.onurkus.fourthhomework.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserSaveDto userSaveDto){

        UserDto userDto = userService.save(userSaveDto);

        return ResponseEntity.ok(userDto);
    }

}
