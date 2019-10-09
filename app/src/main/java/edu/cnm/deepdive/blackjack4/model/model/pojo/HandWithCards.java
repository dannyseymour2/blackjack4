package edu.cnm.deepdive.blackjack4.model.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.blackjack4.model.model.entity.Card;
import edu.cnm.deepdive.blackjack4.model.model.entity.Hand;
import java.util.List;

public class HandWithCards extends Hand {

  @Relation(entity = Card.class, entityColumn = "hand_id", parentColumn = "hand_id")
  private List<Card> cards;

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

}
