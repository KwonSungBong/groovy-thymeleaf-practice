package com.example.demo.service

import com.example.demo.component.LocaleResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource

import javax.servlet.http.HttpServletRequest

/**
 * Created by ksb on 2017. 12. 20..
 */
class LocaleService {

    @Autowired
    MessageSource messageSource

    @Autowired
    LocaleResolver localeResolver

    String getMessage(String code, HttpServletRequest request){
        messageSource.getMessage(code, null, localeResolver.resolveLocale(request))
    }

    String getMessage(String code){
        messageSource.getMessage(code, null, new Locale("en"))
    }

}
