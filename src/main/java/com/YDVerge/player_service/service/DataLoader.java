package com.YDVerge.player_service.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.YDVerge.player_service.model.Item;
import com.YDVerge.player_service.repo.ItemRepository;

@Component
public class DataLoader implements CommandLineRunner {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    public DataLoader(ItemRepository itemRepository,ItemService itemService) {
        this.itemRepository = itemRepository;
        this.itemService = itemService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started. Loading data...");

        // Example: create 5 random items
            List<Item> item = ItemGenerator.getRandomItems(20);
            itemRepository.saveAll(item);
            System.out.println(itemRepository.findAll());
            
            System.out.println("""
            		---------------------------------
            		---------------------------------
            		---------------------------------
            		""");
            System.out.println("Getting Loot................");
            System.out.println(itemService.getLoot());
        }
    }
