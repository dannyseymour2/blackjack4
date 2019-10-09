package edu.cnm.deepdive.blackjack4.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.blackjack4.model.model.dao.CardDao;
import edu.cnm.deepdive.blackjack4.model.model.dao.HandDao;
import edu.cnm.deepdive.blackjack4.model.model.dao.RoundDao;
import edu.cnm.deepdive.blackjack4.model.model.dao.ShoeDao;
import edu.cnm.deepdive.blackjack4.model.model.entity.Card;
import edu.cnm.deepdive.blackjack4.model.model.entity.Card.Rank;
import edu.cnm.deepdive.blackjack4.model.model.entity.Card.Suit;
import edu.cnm.deepdive.blackjack4.model.model.entity.Hand;
import edu.cnm.deepdive.blackjack4.model.model.entity.Hand.Outcome;
import edu.cnm.deepdive.blackjack4.model.model.entity.Round;
import edu.cnm.deepdive.blackjack4.model.model.entity.Shoe;
import java.util.Date;

@Database(
    entities = {Card.class, Hand.class, Round.class, Shoe.class},
    version = 1, exportSchema = true
)
@TypeConverters(BlackJackDatabase.Converters.class)
public abstract class BlackJackDatabase extends RoomDatabase {

  protected BlackJackDatabase() {}

  private static Application applicationContext;

  public static void setApplicationContext(Application applicationContext) {
    BlackJackDatabase.applicationContext = applicationContext;
  }

  public static BlackJackDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract ShoeDao getShoeDao();

  public abstract CardDao getCardDao();

  public abstract RoundDao getRoundDao();

  public abstract HandDao getHandDao();

  private static class InstanceHolder {

    private static final BlackJackDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, BlackJackDatabase.class, "blackjack_db").build();
    }

  }

  public static class Converters {

    @TypeConverter
    public Long dateToLong(Date date) {
      return (date != null) ? date.getTime() : null;
    }

    @TypeConverter
    public Date longToDate(Long milliseconds) {
      return (milliseconds != null) ? new Date(milliseconds) : null;
    }

    @TypeConverter
    public String enumToString(Enum value) {
      return (value != null) ? value.toString() : null;
    }

    @TypeConverter
    public Outcome stringToOutcome(String name) {
      return (name != null) ? Outcome.valueOf(name) : null;
    }

    @TypeConverter
    public Rank stringToRank(String name) {
      return (name != null) ? Rank.valueOf(name) : null;
    }

    @TypeConverter
    public Suit stringToSuit(String name) {
      return (name != null) ? Suit.valueOf(name) : null;
    }

  }

}