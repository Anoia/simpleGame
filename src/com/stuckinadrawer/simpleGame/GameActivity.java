package com.stuckinadrawer.simpleGame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.stuckinadrawer.simpleGame.game.Player;
import com.stuckinadrawer.simpleGame.game.actions.ActionType;
import com.stuckinadrawer.simpleGame.game.actions.Attack;
import com.stuckinadrawer.simpleGame.game.actions.Counter;

public class GameActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.stuckinadrawer.simpleGame.MESSAGE";

    Player p1 = new Player("Player 1");

    Player p2 = new Player("Player 2");

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    public void continueGame(View view){
        p1.setAction(new Attack());
        p2.setAction(new Counter());

        String text = "BATTLE! \n\n";
        text += p1.getAction().doStuff(p1, p2);
        text+="\n";
        text += p2.getAction().doStuff(p2, p1);
        text += "\n Check poison \n Check death";

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(text);




      //  Intent intent = new Intent(this, DisplayMessageActivity.class);
      // EditText editText = (EditText) findViewById(R.id.edit_message);
      //  String message = editText.getText().toString();
     //   intent.putExtra(EXTRA_MESSAGE, message);
     //   startActivity(intent);
    }
}
