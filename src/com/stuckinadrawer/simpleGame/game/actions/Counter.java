package com.stuckinadrawer.simpleGame.game.actions;

import com.stuckinadrawer.simpleGame.game.Player;

public class Counter extends Action {

    public Counter() {
        this.actionName = "Counter";
        this.actionType = ActionType.COUNTER;
        this.actionDescription = "Counter:\nDeals 2 damage and prevents Bash.";
    }

    @Override
    public String doStuff(Player p1, Player p2) {
        String result = p1.getPlayerName() + " uses " + getActionName() + "\n";
        if (p2.getAction().actionType == ActionType.BLOCK) {
            result += "The damage is avoided by " + p2.getPlayerName() + "'s Block.\n";

        } else {
            int dmg = 2;
            result += p2.getPlayerName() + " takes " + dmg + " damage. \n";
            p2.takeDamage(dmg);
        }
        return result;
    }
}
