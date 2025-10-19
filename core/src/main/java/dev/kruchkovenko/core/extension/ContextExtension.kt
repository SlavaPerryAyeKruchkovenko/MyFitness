package dev.kruchkovenko.core.extension

import android.content.Context
import androidx.annotation.Dimension
import androidx.annotation.Px

object ContextExtension {
    @Px
    fun Context.dpToPx(@Dimension(unit = Dimension.DP) value: Int): Int {
        return (value * resources.displayMetrics.density).toInt()
    }
}
