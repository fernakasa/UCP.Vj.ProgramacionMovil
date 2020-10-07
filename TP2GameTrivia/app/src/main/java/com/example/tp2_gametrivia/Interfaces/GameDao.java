package com.example.tp2_gametrivia.Interfaces;

import com.example.tp2_gametrivia.Entidades.Game;
import com.example.tp2_gametrivia.Entidades.Player;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface GameDao {
    @Query("SELECT COUNT(*) FROM game")
    int count();

    // INSERT GAME
    @Insert
    void insert(Game game);
}
