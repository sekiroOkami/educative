package com.educative.spring.controllers;

import com.educative.spring.entities.Player;
import com.educative.spring.entities.PlayerProfile;
import com.educative.spring.service.PlayerProfileService;
import com.educative.spring.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @Autowired
    PlayerProfileService profileService;

    @GetMapping
    public List<Player> allPlayer() {
        return playerService.allPlayer();
    }

    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable(name = "id") int id) {
        return playerService.getPlayer(id);
    }

    @PostMapping
    public Player addPlayer(@RequestBody Player player) {
        return playerService.addPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable(name = "id")int id) {
        playerService.deletePlayer(id);
    }

    @PutMapping("/{id}/profiles/{profile_id}")
    public Player assignDetail(
            @PathVariable(name = "id") int id,
            @PathVariable(name = "profile_id") int profile_id
    ) {
        PlayerProfile profile = profileService.getPlayerProfile(profile_id);
        return playerService.assignProfile(id, profile);
    }

}
