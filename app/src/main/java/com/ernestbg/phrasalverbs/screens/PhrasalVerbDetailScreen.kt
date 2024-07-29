package com.ernestbg.phrasalverbs.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.ernestbg.phrasalverbs.navigation.BottomNavItem
import com.ernestbg.phrasalverbs.navigation.PhrasalVerbsScreens
import com.ernestbg.phrasalverbs.view_models.PhrasalVerbDetailViewModel

@Composable
fun PhrasalVerbDetailScreen(
    navController: NavHostController,
    phrasalVerbId: String?
) {
    val viewModel: PhrasalVerbDetailViewModel = hiltViewModel()
    val phrasalVerbWithDetails by viewModel.phrasalVerbWithDetails.collectAsState()

    LaunchedEffect(phrasalVerbId) {
        phrasalVerbId?.toIntOrNull()?.let {
            viewModel.getPhrasalVerbDetailsById(it)
        }
    }

    phrasalVerbWithDetails?.let { details ->
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(
                text = details.phrasalVerb.headword,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = details.phrasalVerb.phonetics ?: "No phonetics available",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))

            details.definitions.forEach { definitionWithExamples ->
                Text(
                    text = definitionWithExamples.definition.guideword ?: "No guideword",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = definitionWithExamples.definition.definition ?: "No definition")
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
    } ?: run {
        //CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

