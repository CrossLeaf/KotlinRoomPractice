package com.eton.kotlinroompractice

import androidx.room.ColumnInfo
import androidx.room.Entity

/**
 * team_table
 * -------------------
 *| name | team_member|
 * -------------------
 *|      |            |
 *|      |            |
 *|      |            |
 * -------------------
 */
@Entity(tableName = "team_table", primaryKeys = arrayOf("name", "team_member"))
data class Team(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "team_member") val member: String
)
