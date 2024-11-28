package com.daniela.medstracker.ui.navigation

import androidx.compose.runtime.ComposableTarget
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.daniela.medstracker.R
import kotlinx.serialization.Serializable

interface Page {}

@Serializable
object HomePage : Page

@Serializable
object MedicationPage : Page

data class NavItem(
    val label: String,
    val icon: Painter,
    val page: Page
)

