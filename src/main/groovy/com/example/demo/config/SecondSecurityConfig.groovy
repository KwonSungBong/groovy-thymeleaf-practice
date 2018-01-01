package com.example.demo.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * Created by ksb on 2017. 12. 31..
 */
@Configuration
@Order(2)
class SecondSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SecondSecurityConfigf(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user")
                .password("password").roles("USER")
    }

}
