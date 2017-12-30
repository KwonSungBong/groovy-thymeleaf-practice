package com.example.demo.controller

import com.example.demo.entity.User
import com.example.demo.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

/**
 * Created by whilemouse on 17. 12. 19.
 */
@Controller
class HomeController {

    @Autowired
    UserService userServiceImpl

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView('home')
        User user = userServiceImpl.getCurrentUser()
        modelAndView.addObject('user', user)
        modelAndView
    }

}
