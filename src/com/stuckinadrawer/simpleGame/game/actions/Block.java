package com.stuckinadrawer.simpleGame.game.actions;

import com.stuckinadrawer.simpleGame.game.Player;

public class Block extends Action {

    public Block(){
        this.actionName = "Block";
        this.actionType = ActionType.BLOCK;
    }

    @Override
    public String doStuff(Player p1, Player p2) {
        return p1.getPlayerName() + " uses "+actionName+".\n";
    }
}
