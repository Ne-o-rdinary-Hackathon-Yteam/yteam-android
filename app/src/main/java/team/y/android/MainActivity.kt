package team.y.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import team.y.android.ui.growth.GrowthScreen
import team.y.android.ui.home.HomeScreen
import team.y.android.ui.mypage.MyPageScreen
import team.y.android.ui.shortform.ShortFormScreen
import team.y.android.ui.theme.Gray40
import team.y.android.ui.theme.Main
import team.y.android.ui.theme.YTeamTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun App() {
    YTeamTheme(
        darkTheme = false,
    ) {
        var currentDestination by remember { mutableStateOf(YTeamDestination.HOME) }
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.shadow(10.dp),
                    containerColor = if (currentDestination == YTeamDestination.SHORT_FORM) Color.DarkGray else Color.White,
                ) {
                    YTeamDestination.entries.forEach { destination ->
                        val isSelected = destination == currentDestination
                        NavigationBarItem(
                            selected = isSelected,
                            onClick = {
                                currentDestination = destination
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(id = destination.iconRes),
                                    tint = if (isSelected) {
                                        Main
                                    } else {
                                        Gray40
                                    },

                                    contentDescription = destination.label,
                                )
                            },
                            label = {
                                Text(
                                    text = destination.label, color = if (isSelected) {
                                        Main
                                    } else {
                                        Gray40
                                    }
                                )
                            },
                        )
                    }
                }
            },
        ) { innerPadding ->
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = innerPadding.calculateBottomPadding()),
            ) {
                when (currentDestination) {
                    YTeamDestination.HOME -> HomeScreen(
                        onNavigateToGrowth = { currentDestination = YTeamDestination.GROWTH }
                    )

                    YTeamDestination.GROWTH -> GrowthScreen()
                    YTeamDestination.SHORT_FORM -> ShortFormScreen()
                    YTeamDestination.MY_PAGE -> MyPageScreen()
                }
            }
        }
    }
}

enum class YTeamDestination(
    val iconRes: Int,
    val route: String,
    val label: String,
) {
    HOME(
        route = "home",
        iconRes = R.drawable.icon_home,
        label = "홈",
    ),
    GROWTH(
        route = "growth",
        iconRes = R.drawable.icon_growth,
        label = "키우기",
    ),
    SHORT_FORM(
        route = "short_form",
        iconRes = R.drawable.icon_short_form,
        label = "숏폼",
    ),
    MY_PAGE(
        route = "my_page",
        iconRes = R.drawable.icon_my_page,
        label = "MY",
    ),
    ;
}

val foregroundBrush: Brush = Brush.verticalGradient(
    listOf(
        Color.Transparent,
        Color.Black,
    )
)
