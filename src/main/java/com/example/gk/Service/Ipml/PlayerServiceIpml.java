package com.example.gk.Service.Ipml;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.gk.Entity.Player;
import com.example.gk.Repository.PlayerRepository;
import com.example.gk.Service.PlayerService;

@Service
public class PlayerServiceIpml implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceIpml(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    
    public Boolean save(Player player) {
    	player.setWhiteDuck(3);
            Player savedPlayer = playerRepository.save(player);
            System.out.println("Saved Player: " + savedPlayer);
            return true;
    }

    
    @Override
    public Boolean update(Player player) {
        Player updatedPlayer = playerRepository.save(player);
        return updatedPlayer != null;
    }
    
    @Override
    public Player getById(Integer id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id)); 
    }
}
