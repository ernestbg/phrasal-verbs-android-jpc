package com.ernestbg.phrasalverbs.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phrasal_verbs")
data class PhrasalVerb(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val headword: String,
    val guideword: String,
    val meaning: String,
    val example: String
)
