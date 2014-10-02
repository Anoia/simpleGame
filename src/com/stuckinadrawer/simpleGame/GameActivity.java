package com.stuckinadrawer.simpleGame;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import com.stuckinadrawer.simpleGame.fragments.ChooseActionFragment;
import com.stuckinadrawer.simpleGame.fragments.PlayerInfoFragment;
import com.stuckinadrawer.simpleGame.fragments.ResolutionFragment;
import com.stuckinadrawer.simpleGame.game.Player;

public class GameActivity extends Activity implements ResolutionFragment.ContinueListener, ChooseActionFragment.ConfirmActionListener {

    public static Player p1 = new Player("Player 1");
    public static Player p2 = new Player("Player 2");

    private PlayerInfoFragment playerInfoFragment;
    private ResolutionFragment resolutionFragment;
    private ChooseActionFragment chooseActionFragment;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        playerInfoFragment = new PlayerInfoFragment();
        resolutionFragment = new ResolutionFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.container1, playerInfoFragment);
        fragmentTransaction.add(R.id.container2, resolutionFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        playerInfoFragment.updateUI();
    }

    @Override
    public void onClickConfirm() {
        if (p2.getAction() != null) {
            //both actions selected
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.container2, resolutionFragment);
            transaction.commit();

            fragmentManager.executePendingTransactions();
            resolutionFragment.doResolution();
        } else {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            chooseActionFragment = new ChooseActionFragment();
            transaction.replace(R.id.container2, chooseActionFragment);
            transaction.commit();
            fragmentManager.executePendingTransactions();


            chooseActionFragment.setPlayer(p2);
        }

        playerInfoFragment.updateUI();

    }

    @Override
    public void onClickContinue() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        chooseActionFragment = new ChooseActionFragment();
        transaction.replace(R.id.container2, chooseActionFragment);
        transaction.commit();
        fragmentManager.executePendingTransactions();

        playerInfoFragment.updateUI();

        chooseActionFragment.setPlayer(p1);

    }
}
