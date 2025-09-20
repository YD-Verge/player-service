package com.YDVerge.player_service.model;

import java.util.EnumMap;
import java.util.Map;

import com.YDVerge.player_service.decorator.PlayerRole;

public class Adventurer implements PlayerRole {

    @Override
    public String getDescription() {
	// TODO Auto-generated method stub
	return "Human";
    }

    @Override
    public Map<StatType, Integer> getStats() {
	Map<StatType, Integer> base = new EnumMap<>(StatType.class);
        base.put(StatType.STR, 5);
        base.put(StatType.INT, 5);
        base.put(StatType.HP, 100);
        base.put(StatType.DEF, 0);
        base.put(StatType.AGI, 5);
        base.put(StatType.LCK, 10);
        return base;
    }
}
