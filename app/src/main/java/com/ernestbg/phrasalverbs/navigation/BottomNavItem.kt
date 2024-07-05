package com.ernestbg.phrasalverbs.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val label: String, val icon: ImageVector, val route: String) {
    object Dictionary : BottomNavItem("Diccionario", Icons.Filled.Search, "dictionary")
    object Statistics : BottomNavItem("Estadísticas", Icons.Filled.Person, "statistics")
}