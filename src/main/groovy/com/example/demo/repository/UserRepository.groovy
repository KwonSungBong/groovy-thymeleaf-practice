package com.example.demo.repository

import com.example.demo.entity.User
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by whilemouse on 17. 12. 19.
 */
interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username)

    User findByEmail(String email)

}