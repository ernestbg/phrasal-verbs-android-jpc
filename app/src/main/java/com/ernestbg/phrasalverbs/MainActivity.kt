package com.ernestbg.phrasalverbs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ernestbg.phrasalverbs.screens.MainScreen
import com.ernestbg.phrasalverbs.ui.theme.PhrasalVerbsTheme
import com.ernestbg.phrasalverbs.utils.copyDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        copyDatabase(this, "phrasal-verbs.db")
        setContent {
            PhrasalVerbsTheme {
                MainScreen()
            }
        }
    }
}

