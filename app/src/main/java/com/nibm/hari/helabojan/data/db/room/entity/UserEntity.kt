package com.nibm.hari.helabojan.data.db.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "username") val userName: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "age") val age: Int,
)
