package com.stuckinadrawer.simpleGame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.stuckinadrawer.simpleGame.game.Player;
import com.stuckinadrawer.simpleGame.game.actions.ActionType;
import com.stuckinadrawer.simpleGame.game.actions.Attack;
import com.stuckinadrawer.simpleGame.game.actions.Counter;

public class GameActivity extends Activity {

    static Player p1 = new Player("Player 1");
    static Player p2 = new Player("Player 2");

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);



        if(p1.getAction() != null){
            makeThingsHappen();
        }
        updateUI();


    }

    private void updateUI() {
        TextView textView = (TextView) findViewById(R.id.p1_name);
        textView.setText(p1.getPlayerName());
        textView = (TextView) findViewById(R.id.p2_name);
        textView.setText(p2.getPlayerName());

        textView = (TextView) findViewById(R.id.p1_hp);
        textView.setText(p1.getHealth() + " hp");
        textView = (TextView) findViewById(R.id.p2_hp);
        textView.setText(p2.getHealth() + " hp");

        textView = (TextView) findViewById(R.id.p1_poisoned);
        if(p1.isPoisoned()){
            textView.setText("poisoned");
        }else{
            textView.setText(" ");
        }

        textView = (TextView) findViewById(R.id.p2_poisoned);
        if(p2.isPoisoned()){
            textView.setText("poisoned");
        }else{
            textView.setText(" ");
        }

    }

    private void makeThingsHappen() {
        String text = "";
        text += p1.getAction().doStuff(p1, p2);
        text += "\n";

        text += p2.getAction().doStuff(p2, p1);
        text += "\n";

        if(p1.isPoisoned()){
            p1.takeDamage(1);
            text+=p1.getPlayerName()+" takes damage from Poison. \n";

        }
        if(p2.isPoisoned()){
            p2.takeDamage(1);
            text+=p2.getPlayerName()+" takes damage from Poison. \n";
        }

        if(p1.getHealth() <= 0 && p2.getHealth() <= 0){
            text += "\n THE BATTLE IS OVER! NO ONE HAS WON!";
            text += "\n EVERYONE IS DEAD! MUAHAHAHAHAAAA!";
            Button b = (Button) findViewById(R.id.button);
            b.setVisibility(View.GONE);
        }else if(p1.getHealth() <= 0){
            text += "\n THE BATTLE IS OVER! \n\n"+p2.getPlayerName()+" HAS WON!";
            Button b = (Button) findViewById(R.id.button);
            b.setVisibility(View.GONE);
        }else if(p2.getHealth() <= 0){
            text += "\n THE BATTLE IS OVER! \n\n"+p1.getPlayerName()+" HAS WON!";
            Button b = (Button) findViewById(R.id.button);
            b.setVisibility(View.GONE);
        }



        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(text);

        p1.clearAction();
        p2.clearAction();

    }


    public void continueGame(View view){
        startActivity(new Intent(this, ChooseActionActivity.class));
    }
}
