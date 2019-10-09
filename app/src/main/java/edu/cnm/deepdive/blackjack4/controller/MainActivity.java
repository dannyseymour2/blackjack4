package edu.cnm.deepdive.blackjack4.controller;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.blackjack4.R;
import edu.cnm.deepdive.blackjack4.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
    viewModel.getRound().observe(this, (round) -> {
    });
    Button addDeck = findViewById(R.id.start_round);
    addDeck.setOnClickListener((view) -> viewModel.startRound());

  }



}