package com.stuckinadrawer.simpleGame.game;


import com.stuckinadrawer.simpleGame.game.actions.Action;

public class Player {

    private final int maxHealth = 20;
    private int health;

    private String playerName;

    private Action action = null;

    private boolean poisoned = false;


    public Player(String playerName) {
        this.playerName = playerName;
        health = maxHealth;
    }


    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public boolean isPoisoned() {
        return poisoned;
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int amount) {
        this.health -= amount;
    }

    public void heal(int amount) {
        this.health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public void clearAction() {
        action = null;
        System.out.println(this.playerName + " action set to null");

    }
}
