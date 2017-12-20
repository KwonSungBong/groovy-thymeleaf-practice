package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ksb on 2017. 12. 20..
 */
@Controller
public class IndexContorller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home(Model model) {
        model.addAttribute("data", "datadata");
        return "index";
    }

}
