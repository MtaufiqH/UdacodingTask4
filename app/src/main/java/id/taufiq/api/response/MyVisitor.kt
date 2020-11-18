package id.taufiq.api.response


import com.google.gson.annotations.SerializedName

data class MyVisitor(
    @SerializedName("status")
    val status: String,
    @SerializedName("visitor")
    val visitor: List<Visitor>
)