package dev.kruchkovenko.core.model

import androidx.annotation.StringRes
import dev.kruchkovenko.core.R

enum class WorkoutTypeUI(@StringRes val text: Int) {
    All(R.string.all), Training(R.string.training), Ether(R.string.ether), Complex(R.string.complex);
}
