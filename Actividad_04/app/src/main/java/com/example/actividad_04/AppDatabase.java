package com.example.actividad_04;

import com.example.actividad_04.Dao.GameDao;
import com.example.actividad_04.Dao.GameRegionDao;
import com.example.actividad_04.Dao.RegionDao;
import com.example.actividad_04.Dao.SaleDao;
import com.example.actividad_04.Entity.GameEntity;
import com.example.actividad_04.Entity.GameEntityRegionEntityCrossRef;
import com.example.actividad_04.Entity.RegionEntity;
import com.example.actividad_04.Entity.SaleEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {GameEntity.class, RegionEntity.class, SaleEntity.class, GameEntityRegionEntityCrossRef.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract GameDao gameDao();

    public abstract RegionDao regionDao();

    public abstract SaleDao saleDao();

    public  abstract GameRegionDao gameRegionDao();

}
