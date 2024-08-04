package com.ernestbg.phrasalverbs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ernestbg.phrasalverbs.components.BottomNavigationBar
import com.ernestbg.phrasalverbs.components.CenterAlignedTopAppBar
import com.ernestbg.phrasalverbs.navigation.PhrasalVerbsNavigation
import com.ernestbg.phrasalverbs.ui.theme.PhrasalVerbsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhrasalVerbsTheme {
                PhrasalVerbsApp()
            }
        }
    }
}


@Composable
fun PhrasalVerbsApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            PhrasalVerbsNavigation(navController = navController)
        }
    }
}


