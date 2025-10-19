package dev.kruchkovenko.domain.model

enum class WorkoutType(val code: Int) {
    Training(1), Ether(2), Complex(3);

    companion object {
        fun fromCode(code: Int): WorkoutType =
            entries.first { it.code == code }
    }
}
