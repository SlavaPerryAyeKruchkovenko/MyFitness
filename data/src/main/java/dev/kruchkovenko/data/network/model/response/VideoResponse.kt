package dev.kruchkovenko.data.network.model.response

import com.google.gson.annotations.SerializedName

data class VideoResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("duration") val duration: String,
    @SerializedName("link") val link: String,
)
