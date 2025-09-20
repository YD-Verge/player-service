package com.YDVerge.player_service.decorator;

import java.util.EnumMap;
import java.util.Map;

import com.YDVerge.player_service.model.StatType;

public class MageClassDecorator extends PlayerRoleDecorator {
    
    public MageClassDecorator(PlayerRole playerRole) {
	super(playerRole);
    }
    
    public String getDescription() {
        return super.getDescription() + ", who is a Mage";
    }

    @Override
    public Map<StatType, Integer> getStats() {
	Map<StatType, Integer> base = new EnumMap<>(playerRole.getStats());
	base.merge(StatType.INT, 10, Integer::sum);
        base.merge(StatType.HP, -20, Integer::sum);
        base.merge(StatType.LCK, -10, Integer::sum);
        return base;
    }

}
