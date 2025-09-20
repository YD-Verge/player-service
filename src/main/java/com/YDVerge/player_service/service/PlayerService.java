package com.YDVerge.player_service.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.YDVerge.player_service.decorator.MageClassDecorator;
import com.YDVerge.player_service.decorator.TankClassDecorator;
import com.YDVerge.player_service.decorator.WarriorClassDecorator;
import com.YDVerge.player_service.model.Player;

@Service
public class PlayerService {
    private Player player; // single player instance

    // Create a new player
    public Player createPlayer(String id) {
        this.player = new Player(id);
        return player;
    }

    // Get the current player
    public Optional<Player> getPlayer() {
        return Optional.ofNullable(player);
    }

    // Set the PlayerClass (Mage/Tank/Warrior) and stats
    public void setPlayerRole(String roleName) {
        if (player == null) return;

        switch (roleName.toLowerCase()) {
            case "mage" -> player.setPlayerRole(new MageClassDecorator(player.getPlayerRole()));
            case "tank" -> player.setPlayerRole(new TankClassDecorator(player.getPlayerRole()));
            case "warrior" -> player.setPlayerRole(new WarriorClassDecorator(player.getPlayerRole()));
            default -> player.setPlayerRole(player.getPlayerRole()); // keep base Role
        }
    }
}
