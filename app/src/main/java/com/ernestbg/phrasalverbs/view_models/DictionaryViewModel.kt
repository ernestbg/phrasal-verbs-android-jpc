package com.ernestbg.phrasalverbs.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ernestbg.phrasalverbs.model.DictionaryEntry
import com.ernestbg.phrasalverbs.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DictionaryViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {
    val dictionaryEntries: LiveData<List<DictionaryEntry>> = repository.getDictionaryEntries()
        .asLiveData(viewModelScope.coroutineContext)
}
