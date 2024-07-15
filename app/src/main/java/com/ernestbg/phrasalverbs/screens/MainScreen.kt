package com.ernestbg.phrasalverbs.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.rememberNavController
import com.ernestbg.phrasalverbs.navigation.BottomNavGraph
import com.ernestbg.phrasalverbs.components.BottomNavigationBar
import com.ernestbg.phrasalverbs.components.CenterAlignedTopAppBarExample

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBarExample()
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        BottomNavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
    }
}