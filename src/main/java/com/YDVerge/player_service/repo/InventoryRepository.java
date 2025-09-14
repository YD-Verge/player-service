package com.YDVerge.player_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.YDVerge.player_service.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}
