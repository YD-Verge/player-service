package com.YDVerge.player_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import com.YDVerge.player_service.repo.ItemRepository;

@SpringBootApplication
public class PlayerServiceApplication {
	
	@Autowired
	ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(PlayerServiceApplication.class, args);
	}
	
	@KafkaListener(topics = "YDVerge", groupId = "abcd")
    public void listen(String in) {
        System.out.println(in);
    }

}