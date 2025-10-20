package dev.kruchkovenko.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WorkoutUI(
    val id: Int,
    val title: String,
    val description: String?,
    val duration: String,
    val type: WorkoutTypeUI,
) : Parcelable
