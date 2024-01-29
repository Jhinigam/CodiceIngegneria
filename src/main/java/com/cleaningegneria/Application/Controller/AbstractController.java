package com.cleaningegneria.Application.Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public abstract class AbstractController {

    @GetMapping("/status")
    @ResponseBody
    public String status(){
        return "OK";
    }

    @GetMapping("/createPost")
    @ResponseBody
    public String creazionePost(){
        return "Post creato";
    }
}
