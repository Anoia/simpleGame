package com.stuckinadrawer.simpleGame.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.stuckinadrawer.simpleGame.GameActivity;
import com.stuckinadrawer.simpleGame.R;

public class PlayerInfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.player_info_fragment, container, false);
    }

    public void updateUI() {
        TextView textView = (TextView) getView().findViewById(R.id.p1_name);
        textView.setText(GameActivity.p1.getPlayerName());
        textView = (TextView) getView().findViewById(R.id.p2_name);
        textView.setText(GameActivity.p2.getPlayerName());

        textView = (TextView) getView().findViewById(R.id.p1_hp);
        textView.setText(GameActivity.p1.getHealth() + " hp");
        textView = (TextView) getView().findViewById(R.id.p2_hp);
        textView.setText(GameActivity.p2.getHealth() + " hp");

        textView = (TextView) getView().findViewById(R.id.p1_poisoned);
        if (GameActivity.p1.isPoisoned()) {
            textView.setText("poisoned");
        } else {
            textView.setText(" ");
        }

        textView = (TextView) getView().findViewById(R.id.p2_poisoned);
        if (GameActivity.p2.isPoisoned()) {
            textView.setText("poisoned");
        } else {
            textView.setText(" ");
        }

    }

}


