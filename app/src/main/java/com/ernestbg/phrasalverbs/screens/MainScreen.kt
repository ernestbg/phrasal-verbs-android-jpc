package com.ernestbg.phrasalverbs.screens


import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.ernestbg.phrasalverbs.navigation.BottomNavGraph
import com.ernestbg.phrasalverbs.components.BottomNavigationBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        BottomNavGraph(navController = navController)
    }
}
