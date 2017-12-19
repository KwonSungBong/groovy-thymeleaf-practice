package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by whilemouse on 17. 12. 19.
 */
@Controller
@RequestMapping("/web")
class WebController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    String index(Model model) {
        model.addAttribute("data", "datadata");
        return "index";
    }

}
