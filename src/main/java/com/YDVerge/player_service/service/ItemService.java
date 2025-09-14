package com.YDVerge.player_service.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.YDVerge.player_service.model.Item;
import com.YDVerge.player_service.repo.ItemRepository;

@Service
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public List<Item> getLoot(){
		List<Item> itemList = itemRepository.findAll();
		return 
				new Random().ints(0, itemList.size()).limit(3).mapToObj(itemList::get).collect(Collectors.toList());
	}
}
