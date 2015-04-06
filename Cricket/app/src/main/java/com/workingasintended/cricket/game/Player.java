package com.workingasintended.cricket.game;

/**
 * Created by gareth on 06 Apr.
 */
public class Player {
    protected double battingSkill;
    protected double bowlingSkill;
    protected String name;
    protected int runsScored;
    protected int ballsFaced;

    public void setBattingSkill(double battingSkill) {
        this.battingSkill = battingSkill;
    }

    public void setBowlingSkill(double bowlingSkill) {
        this.bowlingSkill = bowlingSkill;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public double getBattingSkill() {
        return battingSkill;
    }

    public double getBowlingSkill() {
        return bowlingSkill;
    }

    public int getRunsScored() { return runsScored; }

    public int getBallsFaced() { return ballsFaced; }

    public String getName() {
        return name;
    }

    public static Player getRandom() {
        Player player = new Player();
        player.setBattingSkill(1.0);
        player.setBowlingSkill(1.0);
        player.setName("Bob Bobington");
        return player;
    }

    public Player() {
        runsScored = 0;
        ballsFaced = 0;
        battingSkill = 0.0;
        bowlingSkill = 0.0;
        name = "unnamed";
    }
}
