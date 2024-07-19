package com.ernestbg.phrasalverbs.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ernestbg.phrasalverbs.screens.DictionaryScreen
import com.ernestbg.phrasalverbs.screens.LearnScreen
import com.ernestbg.phrasalverbs.view_models.DictionaryViewModel

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController,
        startDestination = BottomNavItem.Dictionary.route,
        modifier = modifier
    ) {
        composable(BottomNavItem.Dictionary.route) {
            val dictionaryViewModel: DictionaryViewModel = hiltViewModel()
            DictionaryScreen(dictionaryViewModel, modifier = modifier)
        }
        composable(BottomNavItem.Learn.route) {
            LearnScreen(modifier = modifier)
        }
    }
}