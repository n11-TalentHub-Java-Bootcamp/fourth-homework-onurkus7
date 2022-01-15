package com.onurkus.fourthhomework.converter;

import com.onurkus.fourthhomework.dto.userdto.UserDto;
import com.onurkus.fourthhomework.dto.userdto.UserSaveDto;
import com.onurkus.fourthhomework.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto convertToUsrUserDtoList(User user);
    List<UserDto> convertToUsrUserDtoList(List<User> userList);
    User convertToUserSaveDto(UserSaveDto userSaveDto);

}