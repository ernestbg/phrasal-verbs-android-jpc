package com.ernestbg.phrasalverbs.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ernestbg.phrasalverbs.screens.DictionaryScreen
import com.ernestbg.phrasalverbs.screens.LearnScreen
import com.ernestbg.phrasalverbs.screens.PhrasalVerbDetailScreen
import com.ernestbg.phrasalverbs.view_models.DictionaryViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Dictionary.route,
        modifier = modifier
    ) {
        composable(BottomNavItem.Dictionary.route) {
            val dictionaryViewModel: DictionaryViewModel = hiltViewModel()
            DictionaryScreen(
                viewModel = dictionaryViewModel,
                navController = navController,
                modifier = modifier
            )
        }
        composable(BottomNavItem.Learn.route) {
            LearnScreen(modifier = modifier)
        }
        composable("phrasal_verb_detail/{phrasalVerbId}") { backStackEntry ->
            val phrasalVerbId = backStackEntry.arguments?.getString("phrasalVerbId")
            PhrasalVerbDetailScreen(
                navController = navController,
                phrasalVerbId = phrasalVerbId
            )
        }
    }
}
