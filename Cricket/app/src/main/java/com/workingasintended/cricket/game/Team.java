package com.workingasintended.cricket.game;

import java.util.ArrayList;

public class Team {

    protected ArrayList<Player> players;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    public static Team getRandom() {
        Team team = new Team();
        for (int i=0; i<11; i++) {
            team.addPlayer(Player.getRandom());
        }
        return team;
    }

    public Team() {
        players = new ArrayList<Player>();
    }

}
