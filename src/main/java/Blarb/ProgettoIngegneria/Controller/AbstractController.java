package Blarb.ProgettoIngegneria.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Component;
import javax.swing.text.html.parser.Entity;

@Component
public abstract class AbstractController {

    @GetMapping("/status")
    @ResponseBody
    public String status(){
        return "OK";
    }
}
