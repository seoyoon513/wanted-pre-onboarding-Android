package com.syoon.news.app.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.syoon.news.app.model.SavedNews

@Database(entities = [SavedNews::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun savedNewsDao(): SavedNewsDao
}