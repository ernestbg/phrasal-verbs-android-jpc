package com.ernestbg.phrasalverbs.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestbg.phrasalverbs.data.PhrasalVerbDao
import com.ernestbg.phrasalverbs.model.DictionaryEntry
import com.ernestbg.phrasalverbs.model.PhrasalVerb
import com.ernestbg.phrasalverbs.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhrasalVerbDetailViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _phrasalVerb = MutableStateFlow<PhrasalVerb?>(null)
    val phrasalVerb: StateFlow<PhrasalVerb?> get() = _phrasalVerb

    fun getPhrasalVerbById(id: Int) {
        viewModelScope.launch {
            _phrasalVerb.value = repository.getPhrasalVerbById(id)
        }
    }
}

