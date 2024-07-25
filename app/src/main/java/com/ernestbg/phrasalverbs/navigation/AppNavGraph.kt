package com.ernestbg.phrasalverbs.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ernestbg.phrasalverbs.screens.MainScreen
import com.ernestbg.phrasalverbs.screens.PhrasalVerbDetailScreen

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "main_screen",
        modifier = modifier
    ) {
        composable("main_screen") {
            MainScreen(navController = navController)
        }
        composable("phrasal_verb_detail/{phrasalVerbId}") { backStackEntry ->
            val phrasalVerbId = backStackEntry.arguments?.getString("phrasalVerbId")
            PhrasalVerbDetailScreen(navController = navController, phrasalVerbId = phrasalVerbId)
        }
    }
}