package com.cleaningegneria.Application.Controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
public abstract class AbstractController {

    @GetMapping("/status")
    @ResponseBody
    public String status(){
        return "OK";
    }

    @GetMapping("/status2")
    @ResponseBody
    public String statusPersonalizzato(@RequestParam String P){
        return "OK " + P;
    }

    @GetMapping("/status3")
    @ResponseBody
    public String statusPersonalizzato(@RequestParam String P, @RequestParam String C){
        return "OK " + P + C;
    }

    @GetMapping("/createPost")
    @ResponseBody
    public String creazionePost(){
        return "Post creato";
    }


}
