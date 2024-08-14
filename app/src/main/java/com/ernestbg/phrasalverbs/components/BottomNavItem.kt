package com.ernestbg.phrasalverbs.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val label: String, val icon: ImageVector, val route: String) {
    data object Dictionary : BottomNavItem("Diccionario", Icons.Filled.Book, "dictionary")
    data object Learn : BottomNavItem("Aprendizaje", Icons.Filled.Person, "learn")
}