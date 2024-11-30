package com.daniela.medstracker.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Medication")
data class Medication(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
//    val dosage: String,
//    val frequency: String,
//    val startDate: String,
//    val endDate: String,
)