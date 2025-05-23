package com.example.gk.Service;

import java.util.List;

import com.example.gk.Entity.Player;





public interface PlayerService {

	Boolean save(Player Book);

	List<Player> findAll();

	Boolean update(Player player);
	Player getById(Integer id);
}
