package com.example.demo.validator

import com.example.demo.entity.Post
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

/**
 * Created by ksb on 2017. 12. 31..
 */
@Component
class PostValidator implements Validator {

    @Override
    boolean supports(Class<?> clazz) {
        Post.class.equals(clazz)
    }

    @Override
    void validate(Object target, Errors errors) {
        Post post = (Post) target
        validate(errors, post)
    }

    void validate(Errors errors, Post post){
        if(post.getName().isEmpty()) {
            errors.rejectValue('name', 'post.error.name.empty')
        }
        if(post.getContent().isEmpty()) {
            errors.rejectValue('content', 'post.error.content.empty')
        }
    }

}
