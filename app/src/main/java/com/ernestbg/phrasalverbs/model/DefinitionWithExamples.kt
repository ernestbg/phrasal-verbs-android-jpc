package com.ernestbg.phrasalverbs.model

import androidx.room.Embedded
import androidx.room.Relation

data class DefinitionWithExamples(
    @Embedded val definition: Definition,
    @Relation(
        parentColumn = "ID",
        entityColumn = "DEFINITION_ID",
        entity = Example::class
    )
    val examples: List<Example>
)


