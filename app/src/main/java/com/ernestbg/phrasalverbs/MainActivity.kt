package com.ernestbg.phrasalverbs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.ernestbg.phrasalverbs.screens.MainScreen
import com.ernestbg.phrasalverbs.ui.theme.PhrasalVerbsTheme
import com.ernestbg.phrasalverbs.view_models.DictionaryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhrasalVerbsTheme {
                MainScreen()
            }
        }
    }
}

