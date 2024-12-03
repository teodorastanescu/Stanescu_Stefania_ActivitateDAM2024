package com.example.seminar4;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao

public interface TerasaDAO {

    @Insert
    void insertTerasa(Terasă terasă);

    @Query("SELECT * FROM Terasa")
    List<Terasă> getTerasa();

    @Delete
    void delete(Terasă terasa);


}
