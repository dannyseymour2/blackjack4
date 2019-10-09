package edu.cnm.deepdive.blackjack4.controller;

import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.blackjack4.R;
import edu.cnm.deepdive.blackjack4.model.model.pojo.HandWithCards;
import edu.cnm.deepdive.blackjack4.viewmodel.MainViewModel;

public class DealerHandFragment extends HandFragment {


  @Override
  public LiveData<HandWithCards> handToObserve(MainViewModel viewModel) {
    return viewModel.getDealerHand();
  }

  @Override
  public int getLayout() {
    return R.layout.fragment_hand;
  }
}

