package com.example.demo.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

/**
 * Created by whilemouse on 17. 12. 19.
 */
@EnableWebSecurity
class SecurityConfig {

    @Autowired
    configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER")
    }

}
