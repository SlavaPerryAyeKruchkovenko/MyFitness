package dev.kruchkovenko.core.presenter

interface EventHandler<T : Event> {
    fun obtainEvent(event: T)
}
