package com.example.tp2_gametrivia.Interfaces;

import com.example.tp2_gametrivia.Entidades.Player;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PlayerDao {
    // SELECT COUNT PLAYER
    @Query("SELECT COUNT(*) FROM player")
    public int count();

    //INSERT PLAYER
    @Insert
    public void insert(Player player);

    //LOGIN PLAYER
    @Query("SELECT * FROM player where username = :username and password= :password limit 1")
    public Player getPlayer(String username, String password);
}
