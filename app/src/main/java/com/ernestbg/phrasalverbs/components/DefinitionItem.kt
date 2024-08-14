package com.ernestbg.phrasalverbs.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ernestbg.phrasalverbs.R
import com.ernestbg.phrasalverbs.model.DefinitionWithExamples

@Composable
fun DefinitionItem(
    definitionWithExamples: DefinitionWithExamples,
    onFavoriteDefinitionClick: () -> Unit
) {
    Column {
        Row(verticalAlignment = Alignment.Top) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = definitionWithExamples.definition.guideword ?: "No guideword",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = definitionWithExamples.definition.definition ?: "No definition",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            IconButton(
                onClick = onFavoriteDefinitionClick,
                modifier = Modifier.align(Alignment.Top) // Alinea el icono con la parte superior del texto
            ) {
                Icon(
                    painter = if (definitionWithExamples.definition.isFavorite) {
                        painterResource(id = R.drawable.baseline_star_24)
                    } else {
                        painterResource(id = R.drawable.baseline_star_outline_24)
                    },
                    contentDescription = "Favorite Definition"
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        definitionWithExamples.examples.forEach { example ->
            Text(
                text = example.example ?: "No example",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = example.translation ?: "No translation",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
