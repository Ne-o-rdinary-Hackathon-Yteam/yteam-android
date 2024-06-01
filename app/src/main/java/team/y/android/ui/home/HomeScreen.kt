package team.y.android.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import team.y.android.R
import team.y.android.ui.theme.Gray0
import team.y.android.ui.theme.Gray20
import team.y.android.ui.theme.Gray30
import team.y.android.ui.theme.Gray40
import team.y.android.ui.theme.Gray50
import team.y.android.ui.theme.Main

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val vm: HomeViewModel = hiltViewModel()
    val state by vm.homeState.collectAsStateWithLifecycle()
    val topAppBarScrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "LOGO") },
                scrollBehavior = topAppBarScrollBehavior,
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "알림",
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "마이페이지",
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding)
                .nestedScroll(topAppBarScrollBehavior.nestedScrollConnection),
            verticalArrangement = Arrangement.spacedBy(48.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                if (state.homeState != null) {
                    val pagerState = rememberPagerState {
                        state.homeState!!.data!!.advertisements.size
                    }
                    HorizontalPager(state = pagerState) { page ->
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = 16.dp,
                                    top = 32.dp,
                                    end = 16.dp,
                                )
                                .height(256.dp)
                                .clip(RoundedCornerShape(10.dp)),
                            model = state.homeState!!.data!!.advertisements[page].adUrl,
                            contentScale = ContentScale.Crop,
                            contentDescription = null,
                        )
                    }

                    Surface(
                        modifier = Modifier
                            .width(80.dp)
                            .height(8.dp),
                        color = Color.Red,
                    ) {

                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "룰렛 돌리러 고고",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                OutlinedCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50.dp),
                    colors = CardDefaults.outlinedCardColors(
                        containerColor = Gray0,
                    ),
                    border = BorderStroke(
                        width = 1.dp,
                        color = Gray30,
                    ),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Image(
                            modifier = Modifier
                                .clip(CircleShape)
                                .border(
                                    width = 1.dp,
                                    shape = CircleShape,
                                    color = Main,
                                )
                                .size(64.dp),
                            painter = painterResource(
                                id = R.drawable.ic_launcher_background,
                            ),
                            contentScale = ContentScale.Crop,
                            contentDescription = null,
                        )
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            Text(
                                modifier = Modifier.background(
                                    color = Gray20,
                                ),
                                fontSize = 10.sp,
                                text = "LV.3 JUNJABOY",
                                color = Gray40,
                            )

                            //TODO count
                            var number = 2
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Text(
                                    text = buildAnnotatedString {
                                        withStyle(
                                            SpanStyle(
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Gray50,
                                            ),
                                        ) {
                                            append("룰렛을 ")
                                            withStyle(
                                                SpanStyle(
                                                    color = Main,
                                                ),
                                            ) {
                                                append("${number}번 ")
                                            }
                                            append("돌릴 수 있어요!")
                                        }
                                    },
                                )
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = Icons.Default.ChevronRight,
                                    contentDescription = "자세히",
                                    tint = Gray30,
                                )
                            }
                            Surface(
                                modifier = Modifier
                                    .size(
                                        width = 200.dp, height = 10.dp
                                    )
                                    .clip(
                                        shape = RoundedCornerShape(10.dp),
                                    ),
                                color = Gray30,
                            ) {

                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = "이 농산물 어때요?",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                if (state.homeState != null) {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                    ) {
                        val items = state.homeState!!.data!!.videos
                        items(items) { item ->
                            AsyncImage(
                                modifier = Modifier
                                    .size(
                                        width = 200.dp,
                                        height = 256.dp,
                                    )
                                    .clip(RoundedCornerShape(10.dp)),
                                model = item.thumbnailUrl,
                                contentScale = ContentScale.Crop,
                                contentDescription = null,
                                onError = {
                                    it.result.throwable.printStackTrace()
                                    println("FAILFAIL ${item.thumbnailUrl}")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
