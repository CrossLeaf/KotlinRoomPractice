package com.eton.kotlinroompractice

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TeamEntityTest {
    private lateinit var teamDao: TeamDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        teamDao = db.teamDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeTeamAndReadInList() {
        createTeam()
        val allTeams = teamDao.loadAllTeams()
        assertThat(allTeams.get(0).member, equalTo("andrew"))
    }

    private fun createTeam() {
        teamDao.insertTeams(Team("ios", "andrew"))
    }
}