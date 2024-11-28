package com.daniela.medstracker.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.daniela.medstracker.ui.navigation.NavItem

@Composable
fun BottomNavBar(navItems: List<NavItem>, onItemSelected: (NavItem) -> Unit) {
    var localSelectedIndex by remember { mutableIntStateOf(0) }

    NavigationBar {
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == localSelectedIndex,
                onClick = {
                    localSelectedIndex = index
                    onItemSelected(item)
                },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(28.dp)
                    )
                },
                label = { Text(text = item.label) }
            )
        }
    }
}