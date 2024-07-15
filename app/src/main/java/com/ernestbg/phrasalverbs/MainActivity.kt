package com.ernestbg.phrasalverbs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ernestbg.phrasalverbs.screens.MainScreen
import com.ernestbg.phrasalverbs.ui.theme.PhrasalVerbsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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

