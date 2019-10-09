package edu.cnm.deepdive.blackjack4.model.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.blackjack4.model.model.entity.Hand;
import edu.cnm.deepdive.blackjack4.model.model.entity.Round;
import java.util.List;

public class RoundWithDetails extends Round {

  @Relation(entity = Hand.class, entityColumn = "round_id", parentColumn = "round_id")
  private List<HandWithCards> hands;

  public List<HandWithCards> getHands() {
    return hands;
  }

  public void setHands(List<HandWithCards> hands) {
    this.hands = hands;
  }

}