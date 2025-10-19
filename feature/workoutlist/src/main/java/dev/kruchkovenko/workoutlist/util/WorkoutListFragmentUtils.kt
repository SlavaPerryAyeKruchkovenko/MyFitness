package dev.kruchkovenko.workoutlist.util

import android.content.Context
import android.view.View
import com.google.android.material.chip.Chip
import dev.kruchkovenko.workoutlist.R
import dev.kruchkovenko.workoutlist.databinding.FragmentWorkoutListBinding
import dev.kruchkovenko.workoutlist.model.WorkoutListState
import dev.kruchkovenko.workoutlist.model.WorkoutTypeUI
import dev.kruchkovenko.workoutlist.ui.WorkoutListAdapter

internal object WorkoutListFragmentUtils {

    fun FragmentWorkoutListBinding.showLoading() {
        loader.visibility = View.VISIBLE
        toggleWorkoutContentVisibility(View.GONE)
        errorText.visibility = View.GONE
    }

    fun FragmentWorkoutListBinding.showWorkouts(
        state: WorkoutListState.Display,
        adapter: WorkoutListAdapter
    ) {
        loader.visibility = View.GONE
        toggleWorkoutContentVisibility(View.VISIBLE)
        errorText.visibility = View.GONE

        val chipGroup = filterGroup
        for (i in 0 until chipGroup.childCount) {
            val currentChip = chipGroup.getChildAt(i) as Chip
            val currentType = currentChip.tag as? WorkoutTypeUI
            currentChip.isChecked = currentType == state.workoutType
        }
        adapter.submitList(state.displayWorkouts)
    }

    fun FragmentWorkoutListBinding.showEmpty(context: Context) {
        loader.visibility = View.GONE
        toggleWorkoutContentVisibility(View.GONE)
        errorText.visibility = View.VISIBLE

        errorText.text =
            context.resources.getText(R.string.training_not_found)
    }

    fun FragmentWorkoutListBinding.showError(message: String) {
        loader.visibility = View.GONE
        toggleWorkoutContentVisibility(View.GONE)
        errorText.visibility = View.VISIBLE

        errorText.text = message
    }

    private fun FragmentWorkoutListBinding.toggleWorkoutContentVisibility(visibility: Int) {
        workouts.visibility = visibility
        filter.visibility = visibility
        searchBar.visibility = visibility
    }
}
