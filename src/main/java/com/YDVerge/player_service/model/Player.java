package com.YDVerge.player_service.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.YDVerge.player_service.decorator.PlayerRole;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class Player {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int ID;
	
	private String playerId;
	private int gold;
    private int score;
    private int level;
    private float experience;
    
    @OneToOne
    @JoinColumn(name="inventory_id")
    private Inventory inventory;
    
    @OneToMany
    @ElementCollection
    @CollectionTable(name = "equipped_items", joinColumns = @JoinColumn(name = "id"))
    private List<Item> equippedItems;
    
    @Transient
    private Map<StatType,Integer> stats = new HashMap<>();
    public Player(String id) { this.playerId = id; }
    
    @Transient
    private PlayerRole playerRole = new Adventurer();
    
    public PlayerRole getPlayerRole() {
   	return playerRole;
    }
       
    public void setPlayerRole(PlayerRole playerRole) {
   	this.playerRole = playerRole;
    }
    
}
