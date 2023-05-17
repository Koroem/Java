package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final List<Player> players = new ArrayList<>();

    public List<Player> getAllPlayers() {
        return players;
    }

    public Player addPlayer(Player player) {
        players.add(player);
        return player;
    }

    public Player getPlayer(long id) {
        return players.stream().filter(player -> player.getId() == id).findFirst().orElse(null);
    }

    public void deletePlayer(long id) {
        players.removeIf(player -> player.getId() == id);
    }

    public Player updatePlayer(long id, Player updatedPlayer) {
        int index = players.indexOf(getPlayer(id));
        if (index >= 0) {
            updatedPlayer.setId(id);  // ensure the id is not changed
            players.set(index, updatedPlayer);
            return updatedPlayer;
        }
        return null;
    }
}
