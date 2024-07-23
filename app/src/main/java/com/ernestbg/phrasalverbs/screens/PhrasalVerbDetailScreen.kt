package com.ernestbg.phrasalverbs.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun PhrasalVerbDetailScreen(phrasalVerbId: String) {
    //  obtener el phrasalVerbId y usarlo para cargar los detalles del phrasal verb
    Text(text = "Detail of Phrasal Verb with ID: $phrasalVerbId")
}