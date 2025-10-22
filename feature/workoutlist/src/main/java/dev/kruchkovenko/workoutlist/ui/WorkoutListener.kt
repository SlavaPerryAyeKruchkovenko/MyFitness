package dev.kruchkovenko.workoutlist.ui

import dev.kruchkovenko.core.model.WorkoutUI

interface WorkoutListener {
    fun onWorkoutCardClick(workout: WorkoutUI)
}
