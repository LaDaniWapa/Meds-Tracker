package com.daniela.medstracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.daniela.medstracker.data.dao.MedicationDao
import com.daniela.medstracker.data.entities.Medication

@Database(entities = [Medication::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun medicationDao(): MedicationDao
}