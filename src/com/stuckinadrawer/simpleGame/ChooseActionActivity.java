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

        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                TextView actionDescription = (TextView) findViewById(R.id.actionDescription);
                RadioButton checkedButton = (RadioButton) findViewById(checkedId);
                String actionName = checkedButton.getText().toString();
                Action action;
                if(actionName.equals("Attack")){
                    action = new Attack();
                }else if(actionName.equals("Bash")){
                    action = new Bash();
                }else if(actionName.equals("Block")){
                    action = new Block();
                }else if(actionName.equals("Counter")){
                    action = new Counter();
                }else if(actionName.equals("Poison")){
                    action = new Poison();
                }else{
                    action = new FirstAid();
                }

                p.setAction(action);
                actionDescription.setText(action.getActionDescription());
            }
        });
        group.check(R.id.attack);



    }

    public void confirmAction(View view){
        if(first){
            startActivity(new Intent(this, ChooseActionActivity.class));
        }else{
            startActivity(new Intent(this, GameActivity.class));
        }

    }
}