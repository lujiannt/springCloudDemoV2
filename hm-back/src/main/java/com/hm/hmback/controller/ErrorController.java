package com.hm.hmback.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/error")
@Controller
public class ErrorController {

    @RequestMapping("/403")
    public String error_403() {
        return "/error/403";
    }
}
