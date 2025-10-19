package dev.kruchkovenko.workoutlist.ui.decorator

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.Dimension
import androidx.recyclerview.widget.RecyclerView
import dev.kruchkovenko.core.extension.ContextExtension.dpToPx

class VerticalSpaceItemDecoration(
    @Dimension(unit = Dimension.DP) private val verticalSpaceHeight: Int,
    private val context: Context
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.bottom = context.dpToPx(verticalSpaceHeight)
    }
}
