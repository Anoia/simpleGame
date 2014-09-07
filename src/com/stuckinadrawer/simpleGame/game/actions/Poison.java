package com.stuckinadrawer.simpleGame.game.actions;

import com.stuckinadrawer.simpleGame.game.Player;

public class Poison extends Action{

    public Poison(){
        this.actionName = "Poison";
        this.actionType = ActionType.POISON;
    }

    @Override
    public String doStuff(Player p1, Player p2) {
        if(p2.getAction().getActionType() == ActionType.BLOCK){
            return p1.getPlayerName() + "tries to use "+actionName+", but it is prevented by "+p2.getPlayerName()+"'s "+ p2.getAction().getActionName()+"!\n";
        }else{
            return p1.getPlayerName() + " successfully applies Poison\n";
        }
    }
}
