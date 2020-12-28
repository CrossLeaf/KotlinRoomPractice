package com.eton.kotlinroompractice

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Team::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao
}