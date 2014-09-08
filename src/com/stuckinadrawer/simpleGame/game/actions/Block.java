package com.stuckinadrawer.simpleGame.game.actions;

import com.stuckinadrawer.simpleGame.game.Player;

public class Block extends Action {

    public Block(){
        this.actionName = "Block";
        this.actionType = ActionType.BLOCK;
        this.actionDescription = "Block:\nReduces incoming damage from Attack, Counter or Bash by 2 and prevents Poison being from being applied.";
    }

    @Override
    public String doStuff(Player p1, Player p2) {
        return p1.getPlayerName() + " uses "+actionName+".\n";
    }
}
