package com.YDVerge.player_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.YDVerge.player_service.model.Player;
import com.YDVerge.player_service.service.PlayerService;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/create")
    public Player createPlayer(@RequestBody PlayerRequest request) {
        Player player = playerService.createPlayer(request.getId());
        playerService.setPlayerRole(request.getPlayerRole());
        System.out.println(player.getStats());
        return player;
    }

    @GetMapping("/stats")
    public Player getPlayerStats() {
        return playerService.getPlayer().orElse(null);
    }
}
