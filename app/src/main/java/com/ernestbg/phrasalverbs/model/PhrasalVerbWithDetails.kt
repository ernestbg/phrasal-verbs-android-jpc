package com.ernestbg.phrasalverbs.model

import androidx.room.Embedded
import androidx.room.Relation

data class PhrasalVerbWithDetails(
    @Embedded val phrasalVerb: PhrasalVerb,
    @Relation(
        parentColumn = "ID",
        entityColumn = "PHRASAL_VERB_ID",
        entity = Definition::class // Indicar explícitamente la entidad
    )
    val definitions: List<DefinitionWithExamples>
)


