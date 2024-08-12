package com.ernestbg.phrasalverbs.repository

import android.util.Log
import com.ernestbg.phrasalverbs.data.DefinitionDao
import com.ernestbg.phrasalverbs.data.PhrasalVerbDao
import com.ernestbg.phrasalverbs.model.DictionaryEntry
import com.ernestbg.phrasalverbs.model.PhrasalVerb
import com.ernestbg.phrasalverbs.model.PhrasalVerbWithDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val phrasalVerbDao: PhrasalVerbDao,
    private val definitionDao: DefinitionDao

) {
    fun getDictionaryEntries(): Flow<List<DictionaryEntry>> {
        return phrasalVerbDao.getDictionaryEntries()
            .flowOn(Dispatchers.IO)
            .conflate()
    }
    suspend fun getPhrasalVerbWithDetails(phrasalVerbId: Int): PhrasalVerbWithDetails? {
        return phrasalVerbDao.getPhrasalVerbWithDetails(phrasalVerbId)
    }
    suspend fun updateDefinitionFavoriteStatus(definitionId: Int, isFavorite: Boolean) {
        definitionDao.updateDefinitionFavoriteStatus(definitionId, isFavorite)
    }
}