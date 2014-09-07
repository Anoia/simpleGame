package com.stuckinadrawer.simpleGame.game.actions;

import com.stuckinadrawer.simpleGame.game.Player;

public abstract class Action {

    String actionName;

    ActionType actionType;

    public abstract String doStuff(Player p1, Player p2);

    public String getActionName() {
        return actionName;
    }

    public ActionType getActionType(){
        return actionType;
    }
}
