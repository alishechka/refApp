package com.example.refapplication.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.refapplication.model.RandomPoem;

@Dao
public interface RandomPoemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertRandomPoem(RandomPoem randomPoem);

//    @Query("SELECT* FROM random_poem_table WHERE")
}
