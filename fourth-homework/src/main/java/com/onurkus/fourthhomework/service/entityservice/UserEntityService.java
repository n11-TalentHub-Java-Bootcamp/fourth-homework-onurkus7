package com.onurkus.fourthhomework.service.entityservice;

import com.onurkus.fourthhomework.dao.UserDao;
import com.onurkus.fourthhomework.entity.User;
import com.onurkus.fourthhomework.service.BaseEntityService;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService extends BaseEntityService<User,UserDao> {

    public UserEntityService(UserDao dao) {
        super(dao);
    }


}
