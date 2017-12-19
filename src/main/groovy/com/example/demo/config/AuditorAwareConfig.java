package com.example.demo.config;

import com.example.demo.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Created by ksb on 2017. 12. 19..
 */
@Component
public class AuditorAwareConfig implements AuditorAware<User> {

    @Override
    public User getCurrentAuditor() {
//            return User.class;
        return null;
    }

}
