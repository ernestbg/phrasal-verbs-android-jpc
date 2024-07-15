package com.ernestbg.phrasalverbs.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ernestbg.phrasalverbs.screens.DictionaryScreen
import com.ernestbg.phrasalverbs.screens.LearnScreen

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(navController, startDestination = BottomNavItem.Dictionary.route) {
        composable(BottomNavItem.Dictionary.route) {
            DictionaryScreen()
        }
        composable(BottomNavItem.Learn.route) {
            LearnScreen()
        }
    }
}
