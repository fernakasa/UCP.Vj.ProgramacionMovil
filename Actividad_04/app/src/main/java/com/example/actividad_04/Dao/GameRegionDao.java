package com.example.actividad_04.Dao;

import com.example.actividad_04.Entity.GameEntityRegionEntityCrossRef;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface GameRegionDao {

    @Insert
    public void insert(GameEntityRegionEntityCrossRef... gameEntityRegionEntityCrossRefs);


}
