package id.taufiq.api.response


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("response")
    val response: Boolean
)