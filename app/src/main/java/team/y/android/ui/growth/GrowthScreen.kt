package team.y.android.ui.growth

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import team.y.android.R
import team.y.android.ui.theme.Gray0
import team.y.android.ui.theme.Gray20
import team.y.android.ui.theme.Gray30
import team.y.android.ui.theme.Gray40
import team.y.android.ui.theme.Main
import team.y.android.ui.theme.MainDark
import team.y.android.ui.theme.MainLight

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun GrowthScreen() {
    Scaffold(
        topBar = {

        },
        content = {
            Box {
                Image(
                    painter = painterResource(
                        id = R.drawable.img_groom
                    ),
                    contentDescription = "background",
                    modifier = Modifier
                        .padding(top = 80.dp)
                        .height(340.dp)
                        .fillMaxWidth()
                )/*
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "user",
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.Red),
                modifier = Modifier.align(Alignment.TopEnd)
            )*/
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 10.dp,
                        top = 140.dp,
                        end = 10.dp,
                        bottom = 27.dp,
                    ),
            ) {
                //상단 안내 창
                OutlinedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(82.dp),
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
                    ) {
                        Image(
                            modifier = Modifier
                                .clip(CircleShape)
                                .border(
                                    width = 1.dp,
                                    shape = CircleShape,
                                    color = Main,
                                )
                                .size(58.dp),
                            painter = painterResource(
                                id = R.drawable.img_daangn_profile,
                            ),
                            contentScale = ContentScale.Crop,
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.width(13.dp))
                        Column {
                            Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = "Lv3. 당근",
                                color = Gray40,
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Card(
                                shape = MaterialTheme.shapes.medium,
                            ) {
                                LinearProgressIndicator(
                                    modifier = Modifier.height(10.dp),
                                    progress = 0.8f,
                                    color = Main,
                                    trackColor = Gray20,
                                )
                            }
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(37.dp))

                //캐릭터 이미지
                Image(
                    modifier = Modifier
                        .height(313.dp)
                        .width(164.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(
                        id = R.drawable.img_daangn,
                    ),
                    contentDescription = "character",
                )

                Spacer(modifier = Modifier.height(22.dp))

                //하단 레벨업 창
                val gradient = Brush.verticalGradient(
                    colors = listOf(MainLight, MainDark)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(82.dp)
                        .background(gradient, shape = RoundedCornerShape(50.dp))
                ) {
                    OutlinedCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(82.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.outlinedCardColors(
                            containerColor = Color.Transparent,
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
                        ) {
                            Image(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .border(
                                        width = 1.dp,
                                        shape = CircleShape,
                                        color = Main,
                                    )
                                    .size(58.dp),
                                painter = painterResource(
                                    id = R.drawable.img_carrot_circle,
                                ),
                                contentScale = ContentScale.Crop,
                                contentDescription = null,
                            )
                            Spacer(modifier = Modifier.width(13.dp))
                            Column {
                                Spacer(modifier = Modifier.weight(1f))
                                Text(
                                    text = "레벨업 기회가 4번 남아있어요",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White,
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = "당근 키우러 고고", color = Color.White, fontSize = 10.sp
                                )
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }

            }
        },
    )
}
