package com.ernestbg.phrasalverbs.repository

import android.util.Log
import com.ernestbg.phrasalverbs.data.PhrasalVerbDao
import com.ernestbg.phrasalverbs.model.PhrasalVerb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepository @Inject constructor(private val phrasalVerbDao: PhrasalVerbDao) {

    fun getAllPhrasalVerbs(): Flow<List<PhrasalVerb>> = phrasalVerbDao.getAllPhrasalVerbs()
        .flowOn(Dispatchers.IO)
        .conflate()

    suspend fun insert(phrasalVerb: PhrasalVerb) {
        phrasalVerbDao.insert(phrasalVerb)
    }
}