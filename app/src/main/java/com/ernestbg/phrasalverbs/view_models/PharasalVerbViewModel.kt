package com.ernestbg.phrasalverbs.view_models
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestbg.phrasalverbs.model.PhrasalVerb
import com.ernestbg.phrasalverbs.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhrasalVerbViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _phrasalVerbsList: MutableStateFlow<List<PhrasalVerb>> =
        MutableStateFlow(emptyList())
    val phrasalVerbs: StateFlow<List<PhrasalVerb>> = _phrasalVerbsList

    init {
        fetchPhrasalVerbs()
    }

    private fun fetchPhrasalVerbs() {
        viewModelScope.launch {
            repository.getAllPhrasalVerbs().collect { listOfPhrasalVerbs ->
                _phrasalVerbsList.value = listOfPhrasalVerbs
            }
        }
    }
}

