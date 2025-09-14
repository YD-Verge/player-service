package com.YDVerge.player_service.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.YDVerge.player_service.model.ClassType;
import com.YDVerge.player_service.model.Item;
import com.YDVerge.player_service.model.ItemType;
import com.YDVerge.player_service.model.StatType;

@Component
public class ItemGenerator {

	private static final Random rand = new Random();

	// Updated list of 20 item names
	private static final String[] ITEM_NAMES = {
			"Iron Sword", "Steel Dagger", "Shadow Bow", "Mystic Staff", "Flame Axe",
			"Thunder Hammer", "Crystal Wand", "Poison Blade", "Dragon Spear", "Silver Mace",
			"Golden Shield", "Frost Katana", "Emerald Sling", "Obsidian Dagger", "Phoenix Bow",
			"Lightning Pike", "Cursed Scythe", "Titan Gauntlets", "Shadow Cloak", "Rune Amulet"
	};

	private static final ItemType[] ITEM_TYPES = ItemType.values();
	private static final StatType[] STAT_TYPES = StatType.values();
	private static final ClassType[] CLASS_TYPES = ClassType.values();

	private static Item getRandomItem() {
		Item item = new Item();

		// Random name
		item.setName(ITEM_NAMES[rand.nextInt(ITEM_NAMES.length)]);
		
		item.setClassType(CLASS_TYPES[rand.nextInt(CLASS_TYPES.length)]);

		// Random type
		item.setType(ITEM_TYPES[rand.nextInt(ITEM_TYPES.length)]);

		// Random stat map
		Map<StatType, Integer> stats = new HashMap<>();
		for (StatType stat : STAT_TYPES) {
			stats.put(stat, rand.nextInt(10) + 1); // random 1-10
		}

		item.setStatMap(stats);

		return item;
	}

	public static List<Item> getRandomItems(int n) {
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			items.add(getRandomItem());
		}
		return items;
	}
}
