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
import androidx.navigation.compose.rememberNavController
import com.ernestbg.phrasalverbs.navigation.BottomNavGraph
import com.ernestbg.phrasalverbs.components.BottomNavigationBar
import com.ernestbg.phrasalverbs.components.CenterAlignedTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp) // Altura típica para el top bar
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
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        BottomNavGraph(
            navController = navController, modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}