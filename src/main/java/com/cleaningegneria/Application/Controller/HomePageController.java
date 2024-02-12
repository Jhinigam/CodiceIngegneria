package com.cleaningegneria.Application.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomePageController {

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index.html");
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/Test")
    @ResponseBody
    public String status(){
        return "Connected";
    }
}
