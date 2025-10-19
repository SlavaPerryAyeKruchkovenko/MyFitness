package dev.kruchkovenko.workoutlist.ui

import dev.kruchkovenko.workoutlist.model.WorkoutUI

interface WorkoutListener {
    fun onWorkoutCardClick(workout: WorkoutUI)
}
