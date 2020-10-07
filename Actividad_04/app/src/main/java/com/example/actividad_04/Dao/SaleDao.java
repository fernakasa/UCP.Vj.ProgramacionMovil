package com.example.actividad_04.Dao;

import com.example.actividad_04.Entity.SaleEntity;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface SaleDao {

    @Insert
    public void insert(SaleEntity... saleEntities);
}
