package com.cleaningegneria.Application.Controller;


import com.cleaningegneria.Application.Models.DTO.CreazionePostBaseDTO;
import com.cleaningegneria.Application.Models.DTO.ModificaRuoloDTO;
import com.cleaningegneria.Application.Models.DTO.CreazioneUtenteDTO;
import com.cleaningegneria.Application.Models.Entity.Utente;
import com.cleaningegneria.Application.Service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Post")
public class PostController extends AbstractController{

    @CrossOrigin(origins = "http://localhost:63342")
    @PutMapping("/CreazionePostBase")
    @ResponseBody
    public void CreaPostBase(@RequestBody CreazionePostBaseDTO pDTO){

    }

}
