package com.example.actividad_04.Entity;


import javax.security.auth.Destroyable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Game")
public class GameEntity {
    @PrimaryKey
    public int GameId;

    public String Name;

    public String Description;

    public double Price;

    public int Stock;

}
