package com.GestionJeu.GestionJeu.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    @ResponseBody String ping(){
        return "Success";
    }
}
