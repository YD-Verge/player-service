package com.YDVerge.player_service.model;

import java.util.Map;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    
    @Transient
    private Map<StatType,Integer> statMap;
    
    private ItemType type;
    
    private ClassType classType;
}
