package edu.cnm.deepdive.blackjack4.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import edu.cnm.deepdive.blackjack4.R;
import edu.cnm.deepdive.blackjack4.model.model.pojo.HandWithCards;
import edu.cnm.deepdive.blackjack4.viewmodel.MainViewModel;

public class PlayerHandFragment extends HandFragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = super.onCreateView(inflater, container, savedInstanceState);
    FloatingActionButton hitMe = view.findViewById(R.id.hit_me);
    hitMe.setOnClickListener((v) -> getViewModel().hitPlayer());
    return view;
  }

  @Override
  public LiveData<HandWithCards> handToObserve(MainViewModel viewModel) {
    return viewModel.getPlayerHand();
  }

  @Override
  public int getLayout() {
    return R.layout.fragment_player_hand;
  }

}