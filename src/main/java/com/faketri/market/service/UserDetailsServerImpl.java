package com.faketri.market.service;

import com.faketri.market.entity.User;
import com.faketri.market.repository.UserDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServerImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userDao.findByLogin(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("No Found User %s", username))
                );


        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                user.getRole().stream()
                        .map(x ->
                                new SimpleGrantedAuthority(x.name())
                        ).toList()
        );
    }
}
