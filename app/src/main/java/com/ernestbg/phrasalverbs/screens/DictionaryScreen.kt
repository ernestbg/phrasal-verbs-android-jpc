package com.ernestbg.phrasalverbs.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ernestbg.phrasalverbs.components.DictionaryItem
import com.ernestbg.phrasalverbs.components.SearchBar
import com.ernestbg.phrasalverbs.components.BottomNavItem
import com.ernestbg.phrasalverbs.view_models.DictionaryViewModel

@Composable
fun DictionaryScreen(
    viewModel: DictionaryViewModel = hiltViewModel(),
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val dictionaryEntries by viewModel.dictionaryEntries.observeAsState(emptyList())
    val query by viewModel.query.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        SearchBar(
            query = query,
            onQueryChanged = viewModel::onQueryChanged,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(dictionaryEntries) { entry ->
                DictionaryItem(
                    entry = entry,
                    modifier = Modifier.padding(4.dp),
                    onClick = {
                        navController.navigate("phrasal_verb_detail/${entry.id}") {
                            popUpTo(BottomNavItem.Dictionary.route) { inclusive = false }
                        }
                    }
                )
                Divider(
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f),
                    thickness = 1.dp
                )
            }
        }
    }
}
