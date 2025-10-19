package dev.kruchkovenko.data.network.model.response

import com.google.gson.annotations.SerializedName

data class WorkoutResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String?,
    @SerializedName("type") val type: Int,
    @SerializedName("duration") val duration: String,
)
