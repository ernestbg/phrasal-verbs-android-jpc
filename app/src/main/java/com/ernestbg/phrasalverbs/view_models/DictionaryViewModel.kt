package com.ernestbg.phrasalverbs.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ernestbg.phrasalverbs.model.DictionaryEntry
import com.ernestbg.phrasalverbs.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class DictionaryViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    @OptIn(ExperimentalCoroutinesApi::class, FlowPreview::class)
    val dictionaryEntries: LiveData<List<DictionaryEntry>> = _query
        .debounce(300)
        .flatMapLatest { query ->
            if (query.isEmpty()) {
                repository.getDictionaryEntries()
            } else {
                repository.getDictionaryEntries().map { entries ->
                    entries.filter { it.headword.contains(query, ignoreCase = true) }
                }
            }
        }
        .asLiveData(viewModelScope.coroutineContext)

    fun onQueryChanged(newQuery: String) {
        _query.value = newQuery
    }
}
