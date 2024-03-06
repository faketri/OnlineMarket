package com.faketri.market.usecase.user;

import com.faketri.market.entity.exception.ResourceNotFoundException;
import com.faketri.market.entity.user.gateway.UserRepository;
import com.faketri.market.entity.user.model.Users;
import com.faketri.market.infastructure.user.gateway.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * The type User service.
 *
 * @author Dmitriy Faketri
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userImpl;

    public UserServiceImpl(UserRepository userImpl) {
        this.userImpl = userImpl;
    }

    /**
     * Find by login users.
     *
     * @param login the login
     * @return the users
     */
    public Users findByLogin(String login) {
        return userImpl.findByLogin(login)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Пользователь с логином " + login + " не найден"));
    }

    /**
     * Find by id users.
     *
     * @param id the id
     * @return the users
     */
    public Users findById(UUID id) {
        return userImpl.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User with id " + id + " not found"));
    }

    /**
     * Gets current user.
     *
     * @return the current user
     */
    public Users getCurrentUser() {
        // Получение имени пользователя из контекста Spring Security
        var username = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
        return findByLogin(username);
    }

    /**
     * Save users.
     *
     * @param users the users
     * @return the users
     */
    public Users save(Users users) {
        log.info(String.format("User with login - %s saved"), users.getLogin());
        return userImpl.save(users);
    }

}
