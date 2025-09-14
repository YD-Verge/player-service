package com.YDVerge.player_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;

import java.util.Map;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int size;
    
    @OneToOne
    @JoinColumn(nullable = false)
    private Player playerId;
    
    @Transient
    private Map<Item,Integer> itemMap;
}
