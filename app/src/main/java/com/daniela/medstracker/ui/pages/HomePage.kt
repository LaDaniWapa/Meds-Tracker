package com.daniela.medstracker.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.daniela.medstracker.ui.components.Title

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
    ) {
        Title(text = "Today's Meds")
    }
}