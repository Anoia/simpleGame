package com.stuckinadrawer.simpleGame.game.actions;

import com.stuckinadrawer.simpleGame.game.Player;

public class Bash extends Action{
    @Override
    String doStuff(Player p1, Player p2) {


        if(p2.getAction().getActionType() == ActionType.COUNTER){
            return p1.getPlayerName() + "tries to use "+actionName+", but it is prevented by "+p2.getPlayerName()+"'s "+ p2.getAction().getActionName()+"!\n";
        }else{
            String result = p1.getPlayerName() + "uses "+ actionName+"!\n";
            int dmg = 5;
            if(p2.getAction().getActionType() == ActionType.BLOCK){
                dmg -= 2;
                result += "The damage is reduced by "+p2.getPlayerName()+"'s Block.\n";
            }

            result+=p2.getPlayerName() + " takes " + dmg + " damage. \n";
            p2.takeDamage(dmg);
            return result;
        }


    }
}
