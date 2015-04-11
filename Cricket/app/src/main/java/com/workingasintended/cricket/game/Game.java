package com.workingasintended.cricket.game;

/**
 * Created by gareth on 06 Apr.
 */
public class Game {

    protected Team team1;
    protected Team team2;

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Team getTeam11() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public Shot getNextShot() {
        return new Shot();
    }

    public static Game getRandom() {
        Game game = new Game();
        game.setTeam1(Team.getRandom());
        game.setTeam2(Team.getRandom());
        return game;
    }
}
