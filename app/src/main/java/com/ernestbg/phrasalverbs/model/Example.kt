package com.ernestbg.phrasalverbs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "EXAMPLES",
    foreignKeys = [
        ForeignKey(
            entity = Definition::class,
            parentColumns = ["ID"],
            childColumns = ["DEFINITION_ID"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["DEFINITION_ID"])]
)
data class Example(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    val id: Int = 0,

    @ColumnInfo(name = "DEFINITION_ID")
    val definitionId: Int,

    @ColumnInfo(name = "EXAMPLE")
    val example: String?,

    @ColumnInfo(name = "TRANSLATION")
    val translation: String?
)
