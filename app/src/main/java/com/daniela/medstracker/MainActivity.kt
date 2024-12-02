package com.daniela.medstracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.daniela.medstracker.data.DatabaseHelper
import com.daniela.medstracker.ui.components.BottomNavBar
import com.daniela.medstracker.ui.navigation.HomePage
import com.daniela.medstracker.ui.navigation.MedicationPage
import com.daniela.medstracker.ui.navigation.NavItem
import com.daniela.medstracker.ui.pages.home.HomePage
import com.daniela.medstracker.ui.pages.meds.MedsPage
import com.daniela.medstracker.ui.pages.meds.MedsViewModel
import com.daniela.medstracker.ui.theme.MedsTrackerTheme
import androidx.navigation.NavDestination.Companion.hasRoute
import com.daniela.medstracker.ui.navigation.NewMedicationPage
import com.daniela.medstracker.ui.pages.newme.NewMedPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val baseModifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)

            val navItems = listOf(
                NavItem(
                    label = "Summary",
                    icon = painterResource(id = R.drawable.heart),
                    page = HomePage
                ),
                NavItem(
                    label = "Medications",
                    icon = painterResource(id = R.drawable.medication),
                    page = MedicationPage
                )
            )

            MedsTrackerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        var shouldShowAppBar = false
                        val navBackStackEntry by navController.currentBackStackEntryAsState()

                        navBackStackEntry?.destination?.let { currentDestination ->
                            if (currentDestination.hasRoute(HomePage::class) ||
                                currentDestination.hasRoute(MedicationPage::class)
                            )
                                shouldShowAppBar = true
                        }

                        if (shouldShowAppBar)
                            BottomNavBar(
                                navItems = navItems,
                                onItemSelected = { index ->
                                    navController.navigate(index.page) {
                                        launchSingleTop = true
                                        popUpTo(navController.graph.startDestinationId) {
                                            inclusive = true
                                        }
                                    }
                                }
                            )
                    },

                    ) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = NewMedicationPage
                    ) {
                        composable<HomePage> {
                            HomePage(modifier = baseModifier)
                        }
                        composable<MedicationPage> {
                            MedsPage(modifier = baseModifier, viewModel = medsViewModel())
                        }
                        composable<NewMedicationPage> {
                            NewMedPage(modifier = baseModifier)
                        }
                    }
                }
            }
        }
    }

    private fun medsViewModel(): MedsViewModel {
        val database = DatabaseHelper().getAppDatabase(this)

        return MedsViewModel(database.medicationDao())
    }
}
