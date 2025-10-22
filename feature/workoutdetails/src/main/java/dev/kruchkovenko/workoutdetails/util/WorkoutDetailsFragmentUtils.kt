package dev.kruchkovenko.workoutdetails.util

import android.content.Context
import android.view.View
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import dev.kruchkovenko.core.R
import dev.kruchkovenko.workoutdetails.databinding.FragmentWorkoutDetailsBinding
import dev.kruchkovenko.workoutdetails.model.WorkoutDetailsState

internal object WorkoutDetailsFragmentUtils {

    fun FragmentWorkoutDetailsBinding.showLoading() {
        loader.visibility = View.VISIBLE
        container.visibility = View.GONE
        errorText.visibility = View.GONE
    }

    fun FragmentWorkoutDetailsBinding.showWorkoutDetails(
        state: WorkoutDetailsState.Display,
        context: Context
    ): ExoPlayer? {
        loader.visibility = View.GONE
        container.visibility = View.VISIBLE
        errorText.visibility = View.GONE

        val workout = state.workout
        val workoutType = context.resources.getString(workout.type.text)

        title.text = workout.title
        type.text = context.resources.getString(R.string.workout_type, workoutType)
        duration.text = when (val duration = workout.duration.toIntOrNull()) {
            null -> workout.duration
            else -> context.resources.getString(R.string.workout_duration, duration)
        }
        description.text = workout.description

        return workout.video?.let { videoUI ->
            ExoPlayer.Builder(context).build().apply {
                player.player = this
                setMediaItem(MediaItem.fromUri(videoUI.link))
                prepare()
                playWhenReady = false
            }
        }
    }

    fun FragmentWorkoutDetailsBinding.showError(message: String) {
        loader.visibility = View.GONE
        container.visibility = View.GONE
        errorText.visibility = View.VISIBLE

        errorText.text = message
    }
}
