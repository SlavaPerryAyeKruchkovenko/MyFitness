package dev.kruchkovenko.workoutlist.model

import androidx.annotation.StringRes
import dev.kruchkovenko.domain.model.WorkoutType
import dev.kruchkovenko.workoutlist.R

enum class WorkoutTypeUI(@StringRes val text: Int) {
    All(R.string.all), Training(R.string.training), Ether(R.string.ether), Complex(R.string.complex);

    companion object {
        fun fromWorkType(type: WorkoutType): WorkoutTypeUI =
            entries.first { it.name == type.name }
    }
}
