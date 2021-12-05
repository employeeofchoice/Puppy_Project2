package com.hrsalterego.puppyproject1.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hrsalterego.puppyproject1.network.DogPhoto

@Database(entities = [DogPhoto::class],version = 1)
abstract class DogDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao
}