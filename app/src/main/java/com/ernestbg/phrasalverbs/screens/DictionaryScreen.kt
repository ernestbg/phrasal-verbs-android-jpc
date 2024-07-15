package com.ernestbg.phrasalverbs.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ernestbg.phrasalverbs.view_models.PhrasalVerbViewModel

@Composable
fun DictionaryScreen(viewModel: PhrasalVerbViewModel = hiltViewModel()) {
    val phrasalVerbs by viewModel.phrasalVerbs.collectAsState()

    LazyColumn {
        items(phrasalVerbs) { phrasalVerb ->
            Text(text = phrasalVerb.guideword)
            // Aquí puedes mostrar otros detalles del phrasal verb si es necesario
        }
    }
}