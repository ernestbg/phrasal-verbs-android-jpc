package com.ernestbg.phrasalverbs.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ernestbg.phrasalverbs.model.DictionaryEntry

@Composable
fun DictionaryItem(entry: DictionaryEntry) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = entry.headword, style = MaterialTheme.typography.bodyMedium)
        Text(text = entry.guideword, style = MaterialTheme.typography.bodyLarge)
    }
}