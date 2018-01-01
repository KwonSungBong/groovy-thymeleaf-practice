package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.ModelAndView

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * Created by ksb on 2017. 12. 31..
 */
@Controller
class HandlerException implements HandlerExceptionResolver {

    ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        def data = [:]
        data.message = ex.message
        ModelAndView modelAndView = new ModelAndView("error")
        modelAndView.addObject("data", data)
        modelAndView
    }
}
