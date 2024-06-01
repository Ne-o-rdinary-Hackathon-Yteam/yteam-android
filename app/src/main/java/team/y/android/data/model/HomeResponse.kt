package team.y.android.data.model

data class HomeResponse(
    override val success: Boolean,
    override val code: Int,
    override val message: String,
    override val data: HomeResponseData?,
) : CommonResponse() {
    data class HomeResponseData(
        val advertisements: List<AdvertisementResponse>,
        val videos: List<VideoResponse>,
        val stories: List<StoreResponse>,
    )
}

data class AdvertisementResponse(
    val id: Int,
    val title: String,
    val content: String,
    val adUrl: String,
)

data class VideoResponse(
    val id: Int,
    val title: String,
    val thumbnailUrl: String,
)

data class StoreResponse(
    val id: Int,
    val storeName: String,
    val imgUrl: String,
    val hashtags: String,
)


data class Banner(
    val imageUrl: String,
    val title: String,
    val description: String,
)

val dummyBanners = listOf(
    Banner(
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSR7ahvb8aEN76vOIivqeFpa9_gBV5rZm2erw&s",
        title = "어쩌구저쩌구\n쌸라쌸라블라블라",
        description = "어쩌구저쩌구할 수 있어요.",
    ),
    Banner(
        imageUrl = "https://vlsci.com/wp-content/uploads/2022/07/melissa-askew-y4xZxzN754M-unsplash-scaled.jpg",
        title = "어쩌구저쩌구\n쌸라쌸라블라블라",
        description = "어쩌구저쩌구할 수 있어요.",
    ),
    Banner(
        imageUrl = "https://www.agrifac.com/app/uploads/2020/11/Maize.jpg",
        title = "어쩌구저쩌구\n쌸라쌸라블라블라",
        description = "어쩌구저쩌구할 수 있어요.",
    ),
    Banner(
        imageUrl = "https://scx2.b-cdn.net/gfx/news/hires/2023/agriculture-study-on-c.jpg",
        title = "어쩌구저쩌구\n쌸라쌸라블라블라",
        description = "어쩌구저쩌구할 수 있어요.",
    ),
    Banner(
        imageUrl = "https://californiagrown.org/wp-content/uploads/2023/03/Paprika-Studios-California-Grown-0771-scaled.jpg",
        title = "어쩌구저쩌구\n쌸라쌸라블라블라",
        description = "어쩌구저쩌구할 수 있어요.",
    ),
)


data class Suggestion(
    val thumbnailImageUrl: String,
    val title: String,
)
