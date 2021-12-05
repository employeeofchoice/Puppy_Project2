package com.hrsalterego.puppyproject1.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hrsalterego.puppyproject1.network.DogPhoto

@Dao
interface DogDao {
    @Query("SELECT * FROM DogPhoto")
    fun getAll(): LiveData<List<DogPhoto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg DogPhoto: DogPhoto)
}