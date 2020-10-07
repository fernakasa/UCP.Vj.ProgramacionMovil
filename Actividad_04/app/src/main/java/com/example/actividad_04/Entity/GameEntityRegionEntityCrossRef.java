package com.example.actividad_04.Entity;


import androidx.room.Entity;

@Entity(tableName = "GameEntity", primaryKeys = {"GameId", "RegionId"})
public class GameEntityRegionEntityCrossRef {

    public int GameId;

    public int RegionId;

    public int Price;

}
