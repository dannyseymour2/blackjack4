package edu.cnm.deepdive.blackjack4.model.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.blackjack2.model.entity.Shoe;
import java.util.Collection;
import java.util.List;

@Dao
public interface ShoeDao {

  @Insert
  long insert(Shoe shoe);

  @Insert
  long[] insert(Shoe... shoes);

  @Insert
  List<Long> insert(Collection<Shoe> shoes);

  @Query("SELECT * FROM Shoe ORDER BY shoe_id ASC")
  LiveData<List<Shoe>> getAll();

  @Query("SELECT * FROM Shoe WHERE shoe_id = :shoeId")
  LiveData<Shoe> getById(long shoeId);

  @Update
  int update(Shoe... shoes);

  @Delete
  int delete(Shoe... shoes);

}