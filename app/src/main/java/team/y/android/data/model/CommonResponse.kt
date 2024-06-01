package team.y.android.data.model

abstract class CommonResponse {
    abstract val success: Boolean
    abstract val code: Int
    abstract val message: String
    abstract val data: Any?
}
