package com.YDVerge.player_service.decorator;

import java.util.Map;


import com.YDVerge.player_service.model.StatType;


public interface PlayerRole {
    String getDescription();
    Map<StatType, Integer> getStats();
}
