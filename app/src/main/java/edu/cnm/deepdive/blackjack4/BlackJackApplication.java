package edu.cnm.deepdive.blackjack4;


import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.blackjack4.service.BlackJackDatabase;

public class BlackJackApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    BlackJackDatabase.setApplicationContext(this);
    final BlackJackDatabase database = BlackJackDatabase.getInstance();
    new Thread(new Runnable() {
      @Override
      public void run() {
        database.getShoeDao().delete();
      }
    }).start();
  }
}
