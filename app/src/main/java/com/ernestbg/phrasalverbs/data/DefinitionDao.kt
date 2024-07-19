package com.ernestbg.phrasalverbs.data

import androidx.room.Dao
import androidx.room.Query
import com.ernestbg.phrasalverbs.model.Definition
import kotlinx.coroutines.flow.Flow

@Dao
interface DefinitionDao {
    @Query("SELECT * FROM DEFINITIONS")
    fun getAllDefinitions(): Flow<List<Definition>>
}