package team.y.android.data.remote

import team.y.android.data.model.CommonResponse

data class GetVideosResponse(
    override val success: Boolean,
    override val code: Int,
    override val message: String,
    override val data: List<GetVideosResponseData>,
    val pageInfo: PageInfoResponse,
) : CommonResponse() {
    data class GetVideosResponseData(
        val id: Int,
        val userName: String,
        val title: String,
        val viewCount: Int,
        val videoUrl: String,
        val storeLink: String,
        val bookmarked: Boolean,
        val thumbnailUrl: String,
    )

    data class PageInfoResponse(
        val page: Int,
        val size: Int,
        val hasNext: Boolean,
        val totalElements: Int,
    )
}