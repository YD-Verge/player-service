package com.YDVerge.player_service.decorator;

import java.util.EnumMap;
import java.util.Map;

import com.YDVerge.player_service.model.StatType;

public class TankClassDecorator extends PlayerRoleDecorator {
    
    public TankClassDecorator(PlayerRole playerRole) {
	super(playerRole);
    }
    
    public String getDescription() {
        return super.getDescription() + ", who is a Tank";
    }

    @Override
    public Map<StatType, Integer> getStats() {
	Map<StatType, Integer> base = new EnumMap<>(playerRole.getStats());
	base.merge(StatType.DEF, 20, Integer::sum);
        base.merge(StatType.HP,  50, Integer::sum);
        base.merge(StatType.LCK, -10, Integer::sum);
        return base;
    }

}
