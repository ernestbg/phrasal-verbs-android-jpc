package com.ernestbg.phrasalverbs.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ernestbg.phrasalverbs.view_models.PhrasalVerbDetailViewModel

@Composable
fun PhrasalVerbDetailScreen(
    navController: NavHostController,
    phrasalVerbId: String? // O el tipo de dato que esperas para el ID
) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Muestra el ID en un Text
        Text(
            text = "Phrasal Verb ID: ${phrasalVerbId ?: "Unknown"}",
            style = MaterialTheme.typography.titleLarge
        )

        // Aquí puedes añadir más elementos y lógica para mostrar los detalles del phrasal verb
    }
}