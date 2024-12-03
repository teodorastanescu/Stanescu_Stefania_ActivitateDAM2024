package com.example.seminar4;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Terasă.class}, version = 0)
public abstract class TerasaDataBase extends RoomDatabase {
    public abstract TerasaDAO terasaDAO();
}
