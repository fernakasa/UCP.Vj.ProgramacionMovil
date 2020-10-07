package com.example.actividad_04.Dao;

import com.example.actividad_04.Entity.RegionEntity;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface RegionDao {

    @Insert
    public void insert(RegionEntity... regionEntities);

}
