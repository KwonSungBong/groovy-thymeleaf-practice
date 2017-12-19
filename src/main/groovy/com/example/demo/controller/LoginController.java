package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by ksb on 2017. 12. 19..
 */
@Controller
public class LoginController {

    @RequestMapping(method=GET, value="/login")
    ModelAndView login(@RequestParam Optional<String> error, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("login");
        if(error.isPresent()){
            modelAndView.addObject("message", "login.error");
        }
        return modelAndView;
    }

//    @RequestMapping(method=GET, value="/logout")
//    String logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication()
//        new SecurityContextLogoutHandler().logout(request, response, auth)
//        return "redirect:/"
//    }

}
