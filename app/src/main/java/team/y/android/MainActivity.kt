package team.y.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import team.y.android.ui.SelectScreen
import team.y.android.ui.growth.GrowthScreen
import team.y.android.ui.home.HomeScreen
import team.y.android.ui.mypage.MyPageScreen
import team.y.android.ui.shortform.ShortFormScreen
import team.y.android.ui.theme.YTeamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YTeamTheme {
                var currentDestination by remember { mutableStateOf(YTeamDestination.HOME) }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomAppBar {
                            YTeamDestination.entries.forEach { destination ->
                                val isSelected = destination == currentDestination
                                NavigationBarItem(
                                    selected = isSelected,
                                    onClick = {
                                        currentDestination = destination
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = if (isSelected) {
                                                destination.icons.selectedIcon
                                            } else {
                                                destination.icons.defaultIcon
                                            },
                                            contentDescription = destination.label,
                                        )
                                    },
                                    label = {
                                        Text(text = destination.label)
                                    },
                                )
                            }
                        }
                    },
                ) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                    ) {
                        when (currentDestination) {
                            YTeamDestination.HOME -> SelectScreen()
                            YTeamDestination.GROWTH -> GrowthScreen()
                            YTeamDestination.SHORT_FORM -> ShortFormScreen()
                            YTeamDestination.MY_PAGE -> MyPageScreen()
                        }
                    }
                }
            }
        }
    }
}

enum class YTeamDestination(
    val icons: DestinationIcons,
    val route: String,
    val label: String,
) {
    HOME(
        route = "home",
        icons = DestinationIcons(
            defaultIcon = Icons.Outlined.Home,
            selectedIcon = Icons.Filled.Home,
        ),
        label = "홈",
    ),
    GROWTH(
        route = "growth",
        icons = DestinationIcons(
            defaultIcon = Icons.Outlined.ShoppingCart,
            selectedIcon = Icons.Filled.ShoppingCart,
        ),
        label = "키우기",
    ),
    SHORT_FORM(
        route = "short_form",
        icons = DestinationIcons(
            defaultIcon = Icons.Outlined.PlayArrow,
            selectedIcon = Icons.Filled.PlayArrow,
        ),
        label = "숏폼",
    ),
    MY_PAGE(
        route = "my_page",
        icons = DestinationIcons(
            defaultIcon = Icons.Outlined.AccountCircle,
            selectedIcon = Icons.Filled.AccountCircle,
        ),
        label = "MY",
    ),
    ;

}

class DestinationIcons(
    val defaultIcon: ImageVector,
    val selectedIcon: ImageVector,
)
