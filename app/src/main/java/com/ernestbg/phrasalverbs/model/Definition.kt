package com.ernestbg.phrasalverbs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "DEFINITIONS",
    foreignKeys = [
        ForeignKey(
            entity = PhrasalVerb::class,
            parentColumns = ["ID"],
            childColumns = ["PHRASAL_VERB_ID"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [Index(value = ["PHRASAL_VERB_ID"])]
)
data class Definition(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id: Int = 0,

    @ColumnInfo(name = "PHRASAL_VERB_ID")
    val phrasalVerbId: Int,

    @ColumnInfo(name = "GUIDEWORD")
    val guideword: String?,

    @ColumnInfo(name = "DIALECT")
    val dialect: String?,

    @ColumnInfo(name = "REGISTER")
    val register: String?,

    @ColumnInfo(name = "DEFINITION")
    val definition: String?,

    @ColumnInfo(name = "TRANSLATION")
    val translation: String?,

    @ColumnInfo(name = "LEVEL")
    val level: String?
)
