package edu.escuelaing.arsw.labs.picasyfamas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import edu.escuelaing.arsw.labs.picasyfamas.service.Service;

@SessionScope
@Controller
public class AppController {

    private Service service;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/togame")
    public String toGame(@RequestParam("digits") int digits, Model model) {
        service = new Service(digits);
        model.addAttribute(service(), service);
        model.addAttribute("finish", !service.getRun());
        return "redirect:game";
    }

    @GetMapping("/game")
    public String getGame(
            @RequestParam(name = "attempt", required = false) Integer attempt,
            Model model) {
        if (service != null && attempt != null) {
            service.setCurrent(attempt);
            service.play();
        }
        model.addAttribute(service(), service);
        model.addAttribute("finish", !service.getRun());
        return "game";
    }

    @GetMapping("/wingame")
    public String wingame() {
        return "redirect:";
    }

    private String service() {
        return Service.class.getSimpleName().toLowerCase();
    }
}
