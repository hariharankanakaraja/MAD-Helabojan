package com.nibm.hari.helabojan.data.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nibm.hari.helabojan.data.db.room.dao.UserDAO
import com.nibm.hari.helabojan.data.db.room.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class HELABOJANDatabase : RoomDatabase() {
    abstract fun getUserDao() : UserDAO
}