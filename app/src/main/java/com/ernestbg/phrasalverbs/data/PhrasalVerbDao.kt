package com.ernestbg.phrasalverbs.data

import androidx.room.Dao
import androidx.room.Query
import com.ernestbg.phrasalverbs.model.PhrasalVerb
import kotlinx.coroutines.flow.Flow


@Dao
interface PhrasalVerbDao {
    @Query("SELECT * FROM phrasal_verbs")
    fun getAllPhrasalVerbs(): Flow<List<PhrasalVerb>>
}

