package com.example.demo.service

import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by whilemouse on 17. 12. 19.
 */
@Service
class UserService {

    @Autowired
    UserRepository userRepository

}
