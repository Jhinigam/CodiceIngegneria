package com.cleaningegneria.Application.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.CrossOrigin;


@Controller
public class HomePageController {

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello world!";
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping("/Test")
    @ResponseBody
    public String status(){
        return "Connected";
    }
}
