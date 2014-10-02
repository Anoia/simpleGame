package com.stuckinadrawer.simpleGame.game.actions;

import com.stuckinadrawer.simpleGame.game.Player;

public class Attack extends Action {

    public Attack() {
        this.actionName = "Attack";
        this.actionType = ActionType.ATTACK;
        this.actionDescription = "Attack:\nDeals 3 damage and prevents First Aid.";
    }

    @Override
    public String doStuff(Player p1, Player p2) {
        String result;
        if (p2.getAction().getActionType() == ActionType.BASH) {
            result = p1.getPlayerName() + " tries to use " + actionName + ", but it is prevented by " + p2.getPlayerName() + "'s " + p2.getAction().getActionName() + "!\n";
        } else {
            result = p1.getPlayerName() + " uses " + actionName + "!\n";
            int dmg = 3;
            if (p2.getAction().getActionType() == ActionType.BLOCK) {
                dmg -= 2;
                result += "The damage is reduced by " + p2.getPlayerName() + "'s Block.\n";
            }

            result += p2.getPlayerName() + " takes " + dmg + " damage. \n";
            p2.takeDamage(dmg);
        }

        return result;
    }
}
