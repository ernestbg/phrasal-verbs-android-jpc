package com.ernestbg.phrasalverbs.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ernestbg.phrasalverbs.screens.DictionaryScreen
import com.ernestbg.phrasalverbs.screens.StatisticsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Dictionary.route) {
        composable(BottomNavItem.Dictionary.route) {
            DictionaryScreen()
        }
        composable(BottomNavItem.Statistics.route) {
            StatisticsScreen()
        }
    }
}
