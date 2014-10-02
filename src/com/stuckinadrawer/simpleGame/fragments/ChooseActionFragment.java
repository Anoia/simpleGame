package com.stuckinadrawer.simpleGame.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.stuckinadrawer.simpleGame.R;
import com.stuckinadrawer.simpleGame.game.Player;
import com.stuckinadrawer.simpleGame.game.actions.*;

public class ChooseActionFragment extends Fragment {

    private Player player;
    private ConfirmActionListener confirmActionListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.choose_action_fragment, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            confirmActionListener = (ConfirmActionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ConfirmActionListener");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        setUpView(getView());
    }

    private void setUpView(View view) {

        RadioGroup group = (RadioGroup) view.findViewById(R.id.radioGroup);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                TextView actionDescription = (TextView) getView().findViewById(R.id.actionDescription);
                RadioButton checkedButton = (RadioButton) getView().findViewById(checkedId);
                String actionName = checkedButton.getText().toString();
                Action action;
                if (actionName.equals("Attack")) {
                    action = new Attack();
                } else if (actionName.equals("Bash")) {
                    action = new Bash();
                } else if (actionName.equals("Block")) {
                    action = new Block();
                } else if (actionName.equals("Counter")) {
                    action = new Counter();
                } else if (actionName.equals("Poison")) {
                    action = new Poison();
                } else {
                    action = new FirstAid();
                }
                System.out.println(player.getPlayerName() + ": changed to " + action.getActionName());
                player.setAction(action);
                actionDescription.setText(action.getActionDescription());
            }
        });


        Button btn = (Button) view.findViewById(R.id.button_confirm);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmActionListener.onClickConfirm();
            }
        });
    }

    public void setPlayer(Player player) {
        this.player = player;
        TextView textView = (TextView) getView().findViewById(R.id.chooseActionPlayerName);
        textView.setText("for " + this.player.getPlayerName());
        RadioGroup group = (RadioGroup) getView().findViewById(R.id.radioGroup);
        group.check(R.id.attack);
    }

    public interface ConfirmActionListener {
        public void onClickConfirm();
    }


}
