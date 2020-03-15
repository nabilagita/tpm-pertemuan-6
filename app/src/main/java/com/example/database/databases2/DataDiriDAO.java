package com.example.database.databases2;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DataDiriDAO {
    @Insert
    Long insertData(DataDiri dataDiri);

    @Query("Select * from datadiri_db")
    DataDiri[] getData();

    @Update
    int updateData(DataDiri item);

    @Delete
    void deleteData(DataDiri item);


}
