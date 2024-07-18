package com.ernestbg.phrasalverbs.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ernestbg.phrasalverbs.model.PhrasalVerb
import kotlinx.coroutines.flow.Flow

@Dao
interface PhrasalVerbDao {
    @Query("SELECT * FROM PHRASAL_VERBS")
    fun getAllPhrasalVerbs(): Flow<List<PhrasalVerb>>

    @Insert
    suspend fun insert(phrasalVerb: PhrasalVerb)
}

