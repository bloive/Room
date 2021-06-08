package com.example.room

import androidx.room.Room

object Database {
    val db: UserDatabase = Room.databaseBuilder(
        App.context!!,
        UserDatabase::class.java, "database-user"
    ).build()
}