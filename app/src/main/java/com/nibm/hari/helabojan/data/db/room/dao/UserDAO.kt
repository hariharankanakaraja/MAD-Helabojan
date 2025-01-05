package com.nibm.hari.helabojan.data.db.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.nibm.hari.helabojan.data.db.room.entity.UserEntity

@Dao
interface UserDAO {

    @Query("SELECT * FROM UserEntity")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM UserEntity WHERE username = :username")
    fun getUserByUsername(username: String): UserEntity?

    @Insert
    fun insertNewUser(user: UserEntity)
}