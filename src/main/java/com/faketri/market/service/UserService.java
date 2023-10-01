package com.faketri.market.service;

import com.faketri.market.entity.User;
import com.faketri.market.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findById(Long id){
        return userDao.findById(id).orElseThrow(
                () -> new RuntimeException(
                        (String.format("User with id - %d, not found", id))
                )
        );
    }
}
