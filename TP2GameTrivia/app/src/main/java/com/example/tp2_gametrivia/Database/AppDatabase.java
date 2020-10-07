package com.example.tp2_gametrivia.Database;

import com.example.tp2_gametrivia.Entidades.Game;
import com.example.tp2_gametrivia.Entidades.Player;
import com.example.tp2_gametrivia.Interfaces.GameDao;
import com.example.tp2_gametrivia.Interfaces.PlayerDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Player.class, Game.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PlayerDao playerDao();

    public abstract GameDao gameDao();

}
