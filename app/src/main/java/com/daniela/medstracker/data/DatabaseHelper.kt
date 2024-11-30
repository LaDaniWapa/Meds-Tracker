package com.daniela.medstracker.data

import android.content.Context
import androidx.room.Room

class DatabaseHelper {
    private var appDatabase: AppDatabase? = null

    fun getAppDatabase(context: Context): AppDatabase {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "medications-db"
            ).build()
        }

        return appDatabase!!
    }
}