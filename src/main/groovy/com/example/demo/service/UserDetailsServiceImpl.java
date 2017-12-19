package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;

/**
 * Created by ksb on 2017. 12. 19..
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository

    @Override
    org.springframework.security.core.userdetails.User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username)
        Set<GrantedAuthority> grantedAuthorities = [] as Set
        grantedAuthorities << new SimpleGrantedAuthority(user.role.toString())
        new org.springframework.security.core.userdetails.User(user.username, user.password, user.enabled, user.accountNonExpired, user.credentialsNonExpired, user.accountNonLocked, grantedAuthorities)
    }

}
