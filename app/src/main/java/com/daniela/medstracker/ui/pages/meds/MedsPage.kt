package com.daniela.medstracker.ui.pages.meds

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniela.medstracker.ui.components.MyButton
import com.daniela.medstracker.ui.components.Title

@Composable
fun MedsPage(modifier: Modifier = Modifier, viewModel: MedsViewModel) {
    val medications = viewModel.medications.collectAsState().value

    Column (
        modifier = modifier
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Title(text = "Medications")
            MyButton(
                onClick = {},
            ) {
                Row (
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Icon(
                        Icons.Default.Add,
                        "Add"
                    )
                    Text(text = "Add", fontSize = 16.sp)
                }
            }
        }

        LazyColumn {
            items(items = medications) { m ->
                Text(text = m.name)
            }
        }
    }
}