package com.faketri.market.repository;

import com.faketri.market.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);
    Optional<User> findByLogin(String Login);
}
