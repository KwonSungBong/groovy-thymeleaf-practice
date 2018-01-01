package com.example.demo.component

import com.example.demo.entity.User
import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

/**
 * Created by ksb on 2017. 12. 20..
 */
@Component
class UserAuditorAware implements AuditorAware<User> {

    @Autowired
    UserRepository userRepository

    @Override
    User getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication()
        if (null == authentication || !authentication.isAuthenticated()) return null
        String username = authentication.getName()
        userRepository.findByUsername(username)
    }

}