package com.faketri.market.repository;

import com.faketri.market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    private NamedParameterJdbcTemplate template;

    public Optional<User> findById(Long id){
        return null;
    }
    public Optional<User> findByLogin(String Login){
        return null;
    }
}
