package com.example.demo.validator

import com.example.demo.entity.Reply
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 * Created by ksb on 2017. 12. 31..
 */
@Component
class ReplyValidator implements Validator {

    @Override
    boolean supports(Class<?> clazz) {
        Reply.class.equals(clazz)
    }

    @Override
    void validate(Object target, Errors errors) {
        Reply reply = (Reply) target
        validate(errors, reply)
    }

    void validate(Errors errors, Reply reply){
        if(reply.getContent().isEmpty()) {
            errors.rejectValue('content', 'reply.error.content.empty')
        }
    }

}
