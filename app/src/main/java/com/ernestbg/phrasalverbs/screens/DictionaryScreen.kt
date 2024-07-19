package com.ernestbg.phrasalverbs.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ernestbg.phrasalverbs.components.DictionaryItem
import com.ernestbg.phrasalverbs.view_models.DictionaryViewModel

@Composable
fun DictionaryScreen(
    viewModel: DictionaryViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val dictionaryEntries by viewModel.dictionaryEntries.observeAsState(emptyList())
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(dictionaryEntries) { entry ->
            DictionaryItem(entry)
        }
    }
}
