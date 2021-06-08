package com.example.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "age") val age: Int?,
    @ColumnInfo(name = "address") val address: String?,
    @ColumnInfo(name = "height") val height: String?,
    @ColumnInfo(name = "profile") val profile: String,
) {
    constructor(
        firstName: String?,
        lastName: String?,
        age: Int?,
        address: String?,
        height: String?,
        profile: String
    ) : this(0, firstName, lastName, age, address, height, profile)
}
