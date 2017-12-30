package com.example.demo.service.impl

import com.example.demo.entity.User
import com.example.demo.repository.UserRepository
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service

/**
 * Created by ksb on 2017. 12. 30..
 */
@Service
class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository


    User getByUsername(String username) {
        userRepository.findByUsername(username)
    }

    User getByEmail(String email) {
        userRepository.findByEmail(email)
    }

    User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication()
        String username = auth.getName()
        userRepository.findByUsername(username)
    }

}
