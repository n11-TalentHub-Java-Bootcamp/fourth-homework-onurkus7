package com.onurkus.fourthhomework.controller;

import com.onurkus.fourthhomework.dto.userdto.UserDto;
import com.onurkus.fourthhomework.dto.userdto.UserSaveDto;
import com.onurkus.fourthhomework.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping
    public ResponseEntity getAll(){

        List<UserDto> userDtoList = userService.findAll();

        return ResponseEntity.ok(userDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){

        UserDto userDto = userService.findById(id);

        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody UserSaveDto userSaveDto){

        UserDto userDto = userService.save(userSaveDto);

        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
