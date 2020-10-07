package com.example.actividad_04.Result;

import com.example.actividad_04.Entity.GameEntity;
import com.example.actividad_04.Entity.GameEntityRegionEntityCrossRef;
import com.example.actividad_04.Entity.RegionEntity;

import java.util.List;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

public class GameWithRegions {

    @Embedded
    public GameEntity Game;

    @Relation(
            parentColumn = "GameId",
            entityColumn = "RegionId",
            associateBy = @Junction(GameEntityRegionEntityCrossRef.class)
    )
    public List<RegionEntity> Regions;

}
