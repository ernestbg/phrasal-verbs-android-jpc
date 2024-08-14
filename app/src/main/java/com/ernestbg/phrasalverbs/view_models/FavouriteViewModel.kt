package com.ernestbg.phrasalverbs.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestbg.phrasalverbs.model.Definition
import com.ernestbg.phrasalverbs.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _favoriteDefinitions = MutableStateFlow<List<Definition>>(emptyList())
    val favoriteDefinitions: StateFlow<List<Definition>> get() = _favoriteDefinitions

    init {
        viewModelScope.launch {
            repository.getFavoriteDefinitions().collect { definitions ->
                _favoriteDefinitions.value = definitions
            }
        }
    }
}
