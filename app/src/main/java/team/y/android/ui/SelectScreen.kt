package team.y.android.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import team.y.android.R
import team.y.android.data.Crop


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SelectScreen() {

    val crops = listOf(
        Crop(name = "당근", painter = painterResource(id = R.drawable.img_carrot)),
        Crop(name = "옥수수", painter = painterResource(id = R.drawable.img_corn)),
        Crop(name = "고구마", painter = painterResource(id = R.drawable.img_sweet_potato)),
        Crop(name = "양배추", painter = painterResource(id = R.drawable.img_cabbage)),
        Crop(name = "사과", painter = painterResource(id = R.drawable.img_apple)),
        Crop(name = "감자", painter = painterResource(id = R.drawable.img_potato)),
    )
    Scaffold(
        containerColor = Color.Black.copy(alpha = 0.7f),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(
                    modifier = Modifier.height(100.dp)
                )
                Text(
                    text = "받고 싶은",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    text = "농작물을 선택해주세요",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
                Text(
                    text = "농작물은 한 번 고르면 바꿀 수 없어요",
                    fontSize = 12.sp,
                    color = Color.White,
                )
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(crops) { item ->
                        Card(
                            modifier = Modifier.height(height = 180.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Spacer(
                                    modifier = Modifier.height(8.dp)
                                )
                                //농작물 이름
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = item.name,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Center,
                                )
                                Image(
                                    painter = item.painter,
                                    contentDescription = "crop_image",
                                    modifier = Modifier.fillMaxHeight().width(140.dp),
                                    contentScale = ContentScale.FillWidth,
                                )
                            }
                        }
                    }
                }
            }


        }

    )
}