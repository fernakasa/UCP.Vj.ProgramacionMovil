package com.example.tp2_gametrivia.Interfaces;

import com.example.tp2_gametrivia.Entidades.Game;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface GameDao {
    @Query("SELECT COUNT(*) FROM game")
    public int count();

    // INSERT GAME
    @Insert
    public void insert(Game game);

    @Query("SELECT SUM(score) FROM game where player_id = :player_id")
    public long getScore(long player_id);

    @Query("SELECT * FROM game WHERE player_id = :player_id ORDER BY score DESC")
    public List<Game> getPlayerScores(long player_id);
}
