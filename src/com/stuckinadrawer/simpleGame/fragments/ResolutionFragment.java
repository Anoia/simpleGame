package com.stuckinadrawer.simpleGame.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.stuckinadrawer.simpleGame.GameActivity;
import com.stuckinadrawer.simpleGame.R;
import com.stuckinadrawer.simpleGame.game.Player;

public class ResolutionFragment extends Fragment {

    private ContinueListener continueListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.resolution_fragment, container, false);

        Button btn = (Button) view.findViewById(R.id.button_continue);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueListener.onClickContinue();
            }
        });


        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof ContinueListener) {
            continueListener = (ContinueListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement ContinueListener");
        }
    }

    public void doResolution() {
        Player p1 = GameActivity.p1;
        Player p2 = GameActivity.p2;
        String text = "";
        text += p1.getAction().doStuff(p1, p2);
        text += "\n";

        text += p2.getAction().doStuff(p2, p1);
        text += "\n";

        if (p1.isPoisoned()) {
            p1.takeDamage(1);
            text += p1.getPlayerName() + " takes damage from Poison. \n";

        }
        if (p2.isPoisoned()) {
            p2.takeDamage(1);
            text += p2.getPlayerName() + " takes damage from Poison. \n";
        }

        if (p1.getHealth() <= 0 && p2.getHealth() <= 0) {
            text += "\n THE BATTLE IS OVER! NO ONE HAS WON!";
            text += "\n EVERYONE IS DEAD! MUAHAHAHAHAAAA!";
            Button b = (Button) getView().findViewById(R.id.button_continue);
            b.setVisibility(View.GONE);
        } else if (p1.getHealth() <= 0) {
            text += "\n THE BATTLE IS OVER! \n\n" + p2.getPlayerName() + " HAS WON!";
            Button b = (Button) getView().findViewById(R.id.button_continue);
            b.setVisibility(View.GONE);
        } else if (p2.getHealth() <= 0) {
            text += "\n THE BATTLE IS OVER! \n\n" + p1.getPlayerName() + " HAS WON!";
            Button b = (Button) getView().findViewById(R.id.button_continue);
            b.setVisibility(View.GONE);
        }


        TextView textView = (TextView) getView().findViewById(R.id.text);
        textView.setText(text);

        p1.clearAction();
        p2.clearAction();

    }

    public interface ContinueListener {
        public void onClickContinue();
    }


}
