package ru.netology.game;

import java.util.ArrayList;
import java.util.Collection;

public class Game {
    private final Collection<Player> players;

    public Game() {
        this.players = new ArrayList<>();
    }

    public void register(Player player) {
        players.add(player);
    }

    public Collection<Player> findAll() {
        return players;
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null && findByName(playerName2) == null) {
            throw new NotRegisteredException("Players" + playerName1 + "," + playerName2 + "not registered");
        }
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player" + playerName1 + "not registered");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player" + playerName2 + "not registered");
        }

        if (findByName(playerName1).getStrength() - findByName(playerName2).getStrength() == 0) {
            return 0;
        }
        if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}

