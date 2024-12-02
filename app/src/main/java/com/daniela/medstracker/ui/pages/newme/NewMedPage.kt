package com.daniela.medstracker.ui.pages.newme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniela.medstracker.ui.components.MyButton
import com.daniela.medstracker.ui.components.Title
import com.daniela.medstracker.ui.theme.MedsTrackerTheme

@Composable
fun NewMedPage(modifier: Modifier = Modifier) {
    var medName by remember { mutableStateOf("") }
    var dosage by remember { mutableStateOf("") }
    val units = listOf(
        "g",
        "mg",
        "ml",
        "%"
    )

    var selectedIndex by remember { mutableIntStateOf(-1) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Title(
            text = "Add a Medication",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = medName,
            onValueChange = { medName = it },
            label = { Text("Medication Name") }
        )

        OutlinedTextField(
            value = dosage,
            onValueChange = { dosage = it },
            label = { Text("Dosage") },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Surface(
            tonalElevation = 10.dp,
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.padding(horizontal = 32.dp)
        ) {
            LazyColumn(
                modifier = Modifier.padding(5.dp)
            ) {
                itemsIndexed(items = units) { index, item ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedIndex == index,
                                onClick = {
                                    selectedIndex = index
                                }
                            )
                            .padding(8.dp)
                    ) {
                        Text(
                            text = item,
                        )

                        if (selectedIndex == index)
                            Icon(
                                contentDescription = "check",
                                imageVector = Icons.Default.Check,
                                tint = MaterialTheme.colorScheme.primary
                            )
                    }

                    if (index != units.size - 1)
                        HorizontalDivider(Modifier.fillMaxWidth(), thickness = 1.dp)
                }
            }
        }

        Spacer(Modifier.weight(1f))

        if (selectedIndex!=1)
            Text(units[selectedIndex])

        MyButton(
            onClick = {}
        ) { Text("Add") }
    }
}

@Preview(showBackground = true)
@Composable
private fun NewMedPagePreview() {
    NewMedPage(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    )
}