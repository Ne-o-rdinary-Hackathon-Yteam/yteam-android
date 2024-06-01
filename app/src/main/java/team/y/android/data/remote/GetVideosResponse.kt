package team.y.android.data.remote

import team.y.android.data.model.CommonResponse

data class GetVideosResponse(
    override val success: Boolean,
    override val code: Int,
    override val message: String,
    override val data: GetVideosResponseData,
    val pageInfoResponse: PageInfoResponse,
) : CommonResponse() {
    class GetVideosResponseData
    data class PageInfoResponse(
        val page: Int,
        val size: Int,
        val hasNext: Boolean,
        val totalElements: Int,
    )
}