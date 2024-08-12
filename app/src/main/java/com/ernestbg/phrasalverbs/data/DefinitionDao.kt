package com.ernestbg.phrasalverbs.data

import android.util.Log
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.ernestbg.phrasalverbs.model.Definition
import kotlinx.coroutines.flow.Flow

@Dao
interface DefinitionDao {
    @Query("UPDATE DEFINITIONS SET IS_FAVORITE = :isFavorite WHERE ID = :definitionId")
    suspend fun updateDefinitionFavoriteStatus(definitionId: Int, isFavorite: Boolean)
}