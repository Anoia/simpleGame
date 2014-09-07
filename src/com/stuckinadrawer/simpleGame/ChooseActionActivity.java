package com.stuckinadrawer.simpleGame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.stuckinadrawer.simpleGame.game.Player;
import com.stuckinadrawer.simpleGame.game.actions.*;

/**
 * Created by Esther on 07/09/2014.
 */
public class ChooseActionActivity extends Activity {
    Player p;
    boolean first = true;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_activity_layout);

        if(GameActivity.p1.getAction() == null){
            p = GameActivity.p1;
        }else{
            p = GameActivity.p2;
            first = false;
        }

        TextView textView = (TextView) findViewById(R.id.chooseActionPlayerName);
        textView.setText("for "+p.getPlayerName());
    }

    public void confirmAction(View view){
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
        int id = group.getCheckedRadioButtonId();
        RadioButton button = (RadioButton) findViewById(id);
        String actionName = button.getText().toString();
        if(actionName.equals("Attack")){
            p.setAction(new Attack());
        }
        if(actionName.equals("Bash")){
            p.setAction(new Bash());
        }
        if(actionName.equals("Block")){
            p.setAction(new Block());
        }
        if(actionName.equals("Counter")){
            p.setAction(new Counter());
        }
        if(actionName.equals("Poison")){
            p.setAction(new Poison());
        }
        if(actionName.equals("FirstAid")){
            p.setAction(new FirstAid());
        }

        if(first){
            startActivity(new Intent(this, ChooseActionActivity.class));
        }else{
            startActivity(new Intent(this, GameActivity.class));
        }

    }
}