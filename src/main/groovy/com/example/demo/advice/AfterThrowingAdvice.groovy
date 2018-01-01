package com.example.demo.advice

import com.example.demo.exception.BusinessException
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

/**
 * Created by ksb on 2017. 12. 31..
 */
@Aspect
@Component
class AfterThrowingAdvice {

    @AfterThrowing(pointcut = "execution(* com.example.demo.service..**.*(..))", throwing = "ex")
    void doRecoveryActions(RuntimeException ex) {
//        log.info "Wrapping exception ${ex}"
        throw new BusinessException(ex.getMessage(), ex)
    }

}
