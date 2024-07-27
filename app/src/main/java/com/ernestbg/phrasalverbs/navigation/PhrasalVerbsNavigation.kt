package com.ernestbg.phrasalverbs.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ernestbg.phrasalverbs.screens.DictionaryScreen
import com.ernestbg.phrasalverbs.screens.LearnScreen
import com.ernestbg.phrasalverbs.screens.PhrasalVerbDetailScreen
import com.ernestbg.phrasalverbs.view_models.DictionaryViewModel

@Composable
fun PhrasalVerbsNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = PhrasalVerbsScreens.DictionaryScreen.route
    ) {
        composable(PhrasalVerbsScreens.DictionaryScreen.route) {
            val dictionaryViewModel: DictionaryViewModel = hiltViewModel()
            DictionaryScreen(
                viewModel = dictionaryViewModel,
                navController = navController
            )
        }
        composable(PhrasalVerbsScreens.LearnScreen.route) {
            LearnScreen(navController = navController)
        }
        composable(
            route = PhrasalVerbsScreens.PhrasalVerbDetailScreen.route,
            arguments = listOf(navArgument("phrasalVerbId") { type = NavType.StringType })
        ) { backStackEntry ->
            val phrasalVerbId = backStackEntry.arguments?.getString("phrasalVerbId")
            PhrasalVerbDetailScreen(
                navController = navController,
                phrasalVerbId = phrasalVerbId
            )
        }
    }
}