package com.ernestbg.phrasalverbs.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ernestbg.phrasalverbs.model.DictionaryEntry
import com.ernestbg.phrasalverbs.model.PhrasalVerb
import kotlinx.coroutines.flow.Flow

@Dao
interface PhrasalVerbDao {
    @Query(
        """
        SELECT phrasal_verbs.ID AS id, phrasal_verbs.HEADWORD AS headword, definitions.GUIDEWORD AS guideword
        FROM phrasal_verbs
        LEFT JOIN definitions ON phrasal_verbs.ID = definitions.PHRASAL_VERB_ID
    """
    )
    fun getDictionaryEntries(): Flow<List<DictionaryEntry>>

    @Query("SELECT * FROM PHRASAL_VERBS WHERE ID = :id")
    suspend fun getPhrasalVerbById(id: Int): PhrasalVerb?
}



