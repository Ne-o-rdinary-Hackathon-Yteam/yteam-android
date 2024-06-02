package team.y.android.ui.shortform

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.animation.core.RepeatMode
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import team.y.android.data.remote.GetVideosResponse
import team.y.android.data.shortFormApiService
import team.y.android.foregroundBrush

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ShortFormScreen() {
    var videos by remember { mutableStateOf<GetVideosResponse?>(null) }
    LaunchedEffect(key1 = Unit) {
        launch(Dispatchers.IO) {
            kotlin.runCatching {
                shortFormApiService.getVideos(0)
            }.onSuccess {
                videos = it
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    actionIconContentColor = Color.White,
                ),
                title = { /*TODO*/ },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.MoreHoriz,
                            contentDescription = "더보기",
                        )
                    }
                },
            )
        },
    ) { _ ->
        if (videos != null) {
            VerticalPager(
                state = rememberPagerState {
                    videos!!.data.size
                },
                beyondBoundsPageCount = 10,
            ) { page ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    VideoPlayer(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .fillMaxSize(),
                        videoUri = Uri.parse(videos!!.data[page].videoUrl)
                    )
                    Surface(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .height(350.dp)
                            .background(brush = foregroundBrush),
                        color = Color.Transparent,
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp)
                                .align(Alignment.BottomCenter),
                            verticalArrangement = Arrangement.spacedBy(
                                space = 20.dp,
                                alignment = Alignment.Bottom,
                            ),
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Column(
                                    modifier = Modifier.weight(1f),
                                ) {
                                    Text(
                                        text = videos!!.data[page].title,
                                        color = Color.White,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                    )
                                    Row {
                                        Text(
                                            text = videos!!.data[page].userName,
                                            color = Color.White,
                                            fontSize = 12.sp,
                                        )
                                        Text(
                                            text = " · ",
                                            color = Color.White,
                                            fontSize = 12.sp,
                                        )
                                        Text(
                                            text = "조회수 ${videos!!.data[page].viewCount}",
                                            color = Color.White,
                                            fontSize = 12.sp,
                                        )
                                    }
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Favorite,
                                            contentDescription = "좋아요",
                                            tint = Color.White,
                                        )
                                        Text(
                                            text = videos!!.data[page].id.toString(),
                                            fontSize = 10.sp,
                                            color = Color.White,
                                        )
                                    }
                                }
                            }
                            val uri = LocalUriHandler.current
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .clickable { uri.openUri(videos!!.data[page].storeLink) },
                                color = Color(0xffEA9898).copy(alpha = 0.2f),
                                shape = RoundedCornerShape(50.dp),
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    AsyncImage(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(CircleShape),
                                        model = videos!!.data[page].thumbnailUrl,
                                        contentDescription = null,
                                    )
                                    Text(
                                        text = videos!!.data[page].title,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,

                                        )
                                    Spacer(modifier = Modifier.weight(1f))
                                    IconButton(onClick = { /*TODO*/ }) {
                                        Icon(
                                            imageVector = Icons.Default.ChevronRight,
                                            contentDescription = "자세히",
                                            tint = Color.White,
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun VideoPlayer(
    modifier: Modifier = Modifier,
    videoUri: Uri,
) {
    val context = LocalContext.current
    val exoPlayer = remember {
        SimpleExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(videoUri))
            prepare()
        }
    }

    AndroidView(
        modifier = modifier,
        factory = { context ->
            PlayerView(context).apply {
                player = exoPlayer
                exoPlayer.play()
            }
        },
    )
}