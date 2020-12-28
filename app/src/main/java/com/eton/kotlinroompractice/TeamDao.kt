package com.eton.kotlinroompractice

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface TeamDao {
    @Insert(onConflict = REPLACE)
    fun insertTeams(vararg teams: Team)

    @Query("SELECT * FROM team_table")
    fun loadAllTeams(): Array<Team>
}