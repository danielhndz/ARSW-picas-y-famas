package edu.escuelaing.arsw.labs.picasyfamas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;

import edu.escuelaing.arsw.labs.picasyfamas.service.Game;

@Controller
@SessionScope
public class AppController {

    private Game game;
    private final Logger logger = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/togame")
    public String toGame(@RequestParam("digits") int digits, Model model) {
        game = new Game(digits);
        model.addAttribute(service(), game);
        model.addAttribute("finish", !game.getRun());
        return "redirect:game";
    }

    @SuppressWarnings("java:S2629") // sonarlint by logger.info(game.toString())
    @GetMapping("/game")
    public String getGame(
            @RequestParam(name = "attempt", required = false) Integer attempt,
            Model model) {
        if (game != null && attempt != null) {
            game.setCurrent(attempt);
            game.play();
        } else if (game == null) {
            return "redirect:index";
        }
        model.addAttribute(service(), game);
        model.addAttribute("finish", !game.getRun());
        logger.info(game.toString());
        return "game";
    }

    @GetMapping("/wingame")
    public String wingame() {
        return "redirect:";
    }

    private String service() {
        return Game.class.getSimpleName().toLowerCase();
    }

}
