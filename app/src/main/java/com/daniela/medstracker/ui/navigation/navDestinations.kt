package com.daniela.medstracker.ui.navigation

import androidx.compose.ui.graphics.painter.Painter
import kotlinx.serialization.Serializable

interface Page {}

@Serializable
object HomePage : Page

@Serializable
object MedicationPage : Page

@Serializable
object NewMedicationPage : Page

data class NavItem(
    val label: String,
    val icon: Painter,
    val page: Page
)

