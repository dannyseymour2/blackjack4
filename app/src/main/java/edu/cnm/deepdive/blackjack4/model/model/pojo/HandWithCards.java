package edu.cnm.deepdive.blackjack4.model.model.pojo;

import androidx.room.Ignore;
import androidx.room.Relation;
import edu.cnm.deepdive.blackjack4.model.model.entity.Card;
import edu.cnm.deepdive.blackjack4.model.model.entity.Card.Rank;
import edu.cnm.deepdive.blackjack4.model.model.entity.Hand;
import java.util.List;

public class HandWithCards extends Hand {
  @Ignore
  private boolean hasAce;


  private
  @Relation(entity = Card.class, entityColumn = "hand_id", parentColumn = "hand_id")
  private List<Card> cards;

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  public int getHardValue(){
    int value = 0;
    hasAce = false;
    for (Card card : cards){
      value += Math.min(card.getRank().ordinal(), 9) + 1;
      if (card.getRank() == Rank.ACE){
        hasAce = true;
      }
    }
    return value;
  }

  public int getSoftValue(){
    int hardValue = getHardValue();
    return hardValue + ((hardValue<12 && hasAce) ? 10 : 0);
  }
}
