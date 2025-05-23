	package com.example.gk.Controller;
	
	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gk.Entity.Player;
import com.example.gk.Service.PlayerService;
	
	@RestController
	@RequestMapping("/api/v1/player")
	public class PlayerController {
	
	    @Autowired
	    private PlayerService PlayerService;
	
	    @GetMapping
	    public ResponseEntity<List<Player>> findAll() {
	        List<Player> Players = PlayerService.findAll();
	        return ResponseEntity.ok(Players);  
	    }
	
	    @PostMapping("/create")
	    public ResponseEntity<Boolean> create(@RequestBody Player player) {
	    	System.out.println("After setWhiteDuck: " + player.getWhiteDuck());
	        Boolean result = PlayerService.save(player);
	        return ResponseEntity.ok(result);
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<String> put(
	        @PathVariable Integer id,
	        @RequestBody Player playerDto
	    ) {
	        Player play = PlayerService.getById(id);
	        if (play == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy id");
	        }
	        try {
	            play.setEgg(playerDto.getEgg());
	            play.setCoins(playerDto.getCoins());
	            play.setWhiteDuck(playerDto.getWhiteDuck());

	            Boolean result = PlayerService.update(play);
	            if (result) {
	                return ResponseEntity.ok("Cập nhật thành công");
	            } else {
	                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                        .body("Có lỗi xảy ra khi cập nhật.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Có lỗi xảy ra: " + e.getMessage());
	        }
	    }

	}
