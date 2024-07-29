package com.ernestbg.phrasalverbs.repository

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
) {
    fun getDictionaryEntries(): Flow<List<DictionaryEntry>> {
        return phrasalVerbDao.getDictionaryEntries()
            .flowOn(Dispatchers.IO)
            .conflate()
    }
    suspend fun getPhrasalVerbWithDetails(phrasalVerbId: Int): PhrasalVerbWithDetails? {
        return phrasalVerbDao.getPhrasalVerbWithDetails(phrasalVerbId)
    }
}