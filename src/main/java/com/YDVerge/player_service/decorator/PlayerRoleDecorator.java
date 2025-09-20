package com.YDVerge.player_service.decorator;

import java.util.Map;

import com.YDVerge.player_service.model.StatType;

public class PlayerRoleDecorator implements PlayerRole {
    
    protected PlayerRole playerRole;
    
    public PlayerRoleDecorator(PlayerRole playerRole) {
        this.playerRole = playerRole;
    }
    public String getDescription() {
        return playerRole.getDescription();
    }
    public Map<StatType, Integer> getStats() {
        return playerRole.getStats();
    }

}
