package team.y.android.data.model

data class BannerResponse(
    val banners: List<Banner>,
)

data class Banner (
    val imageUrl: String,
    val title: String,
    val description: String,
)

val dummyBanners = listOf(
    Banner(
        "","",""
    ),
)
