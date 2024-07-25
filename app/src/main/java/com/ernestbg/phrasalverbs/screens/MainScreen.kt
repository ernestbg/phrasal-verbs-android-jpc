package com.ernestbg.phrasalverbs.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ernestbg.phrasalverbs.components.BottomNavigationBar
import com.ernestbg.phrasalverbs.components.CenterAlignedTopAppBar
import com.ernestbg.phrasalverbs.navigation.BottomNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val bottomNavController = rememberNavController() // Nuevo NavController para la barra de navegación inferior

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                CenterAlignedTopAppBar()
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                BottomNavigationBar(navController = bottomNavController)
            }
        }
    ) { innerPadding ->
        BottomNavGraph(
            navController = bottomNavController,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}
