package com.ernestbg.phrasalverbs.view_models

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestbg.phrasalverbs.data.PhrasalVerbDao
import com.ernestbg.phrasalverbs.model.DictionaryEntry
import com.ernestbg.phrasalverbs.model.PhrasalVerb
import com.ernestbg.phrasalverbs.model.PhrasalVerbWithDetails
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

    private val _phrasalVerbWithDetails = MutableStateFlow<PhrasalVerbWithDetails?>(null)
    val phrasalVerbWithDetails: StateFlow<PhrasalVerbWithDetails?> get() = _phrasalVerbWithDetails

    fun getPhrasalVerbDetailsById(id: Int) {
        viewModelScope.launch {
            _phrasalVerbWithDetails.value = repository.getPhrasalVerbWithDetails(id)
        }
    }

    fun toggleFavoriteStatus(definitionId: Int, currentIsFavorite: Boolean) {
        viewModelScope.launch {
            repository.updateDefinitionFavoriteStatus(definitionId, !currentIsFavorite)
            _phrasalVerbWithDetails.value?.let { details ->
                val updatedDefinitions = details.definitions.map { definitionWithExamples ->
                    if (definitionWithExamples.definition.id == definitionId) {
                        val updatedDefinition = definitionWithExamples.definition.copy(
                            isFavorite = !currentIsFavorite
                        )
                        definitionWithExamples.copy(definition = updatedDefinition)
                    } else {
                        definitionWithExamples
                    }
                }
                _phrasalVerbWithDetails.value = details.copy(definitions = updatedDefinitions)
            }
        }
    }

}


