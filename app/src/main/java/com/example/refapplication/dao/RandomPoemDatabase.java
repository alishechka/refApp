package com.example.refapplication.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.refapplication.model.RandomPoem;

@Database(entities = {RandomPoem.class}, version = 1)
@TypeConverters({StringListConverter.class})
public abstract class RandomPoemDatabase extends RoomDatabase {

    public abstract RandomPoemDao randomPoemDao();

    private static volatile RandomPoemDatabase INSTANCE;

    static RandomPoemDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RandomPoemDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RandomPoemDatabase.class, "random_poem_table")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
