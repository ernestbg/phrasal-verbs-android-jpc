package com.ernestbg.phrasalverbs.view_models

import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ernestbg.phrasalverbs.model.PhrasalVerb
import com.ernestbg.phrasalverbs.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhrasalVerbViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    fun getAllPhrasalVerbs() {
        viewModelScope.launch {
            repository.getAllPhrasalVerbs().collect { phrasalVerbs ->
                if (phrasalVerbs.isNotEmpty()) {
                    for (verb in phrasalVerbs) {
                        Log.d(
                            "ernesto",
                            "Phrasal Verb - ID: ${verb.id}, Headword: ${verb.headword}, Phonetics: ${verb.phonetics ?: "null"}"
                        )
                    }
                } else {
                    Log.d("ernesto", "No Phrasal Verbs found.")
                }
            }
        }
    }

    fun insert(phrasalVerb: PhrasalVerb) {
        viewModelScope.launch {
            repository.insert(phrasalVerb)
        }
    }
}
