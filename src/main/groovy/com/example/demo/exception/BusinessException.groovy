package com.example.demo.exception

import org.springframework.core.NestedRuntimeException

/**
 * Created by ksb on 2017. 12. 31..
 */
class BusinessException extends NestedRuntimeException {

    BusinessException(String msg){
        super(msg)
    }

    BusinessException(String msg, Throwable cause) {
        super(msg, cause)
    }

}
