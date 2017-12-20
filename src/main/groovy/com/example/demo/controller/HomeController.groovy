package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.servlet.ModelAndView

/**
 * Created by whilemouse on 17. 12. 19.
 */
@Controller
class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView('home')
//        modelAndView.addObject('data', "datadata")
        modelAndView
    }

}
