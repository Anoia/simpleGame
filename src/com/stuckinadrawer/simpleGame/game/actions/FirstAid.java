package com.stuckinadrawer.simpleGame.game.actions;

import com.stuckinadrawer.simpleGame.game.Player;

public class FirstAid extends Action{

    public FirstAid(){
        this.actionName = "First Aid";
        this.actionType = ActionType.FIRST_AID;
    }

    @Override
    public String doStuff(Player p1, Player p2) {
        String result;
        if(p2.getAction().getActionType() == ActionType.ATTACK){
            result = p1.getPlayerName() + " tries to use "+actionName+", but it is prevented by "+p2.getPlayerName()+"'s "+ p2.getAction().getActionName()+"!\n";
        }else{
            result = p1.getPlayerName() + " uses First Aid!\n";
            result += p1.getPlayerName() + " heals 3 HP.";
            p1.heal(3);
            if(p1.isPoisoned() && p2.getAction().getActionType() != ActionType.POISON){
                p1.setPoisoned(false);
                result += p1.getPlayerName() + " also heals Poison!";
            }
        }

        return result;
    }
}
