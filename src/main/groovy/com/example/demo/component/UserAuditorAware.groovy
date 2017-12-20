package com.example.demo.component

import com.example.demo.entity.User
import org.springframework.data.domain.AuditorAware
import org.springframework.stereotype.Component

/**
 * Created by ksb on 2017. 12. 20..
 */
@Component
class UserAuditorAware implements AuditorAware<User> {

    @Override
    User getCurrentAuditor() {
        null
    }

}