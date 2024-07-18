package com.ernestbg.phrasalverbs.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo


@Entity(tableName = "PHRASAL_VERBS")
data class PhrasalVerb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id: Int = 0,

    @ColumnInfo(name = "HEADWORD")
    val headword: String,

    @ColumnInfo(name = "PHONETICS")
    val phonetics: String?
)


