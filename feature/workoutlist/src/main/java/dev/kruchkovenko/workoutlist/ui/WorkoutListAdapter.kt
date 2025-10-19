package dev.kruchkovenko.workoutlist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.kruchkovenko.workoutlist.databinding.ItemWorkoutBinding
import dev.kruchkovenko.workoutlist.model.WorkoutUI

class WorkoutListAdapter(
    private val listener: WorkoutListener
) : ListAdapter<WorkoutUI, WorkoutListAdapter.WorkoutViewHolder>(WorkoutDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val context = parent.context
        val binding = ItemWorkoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return WorkoutViewHolder(binding, listener, context)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class WorkoutViewHolder(
        private val binding: ItemWorkoutBinding,
        private val listener: WorkoutListener,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WorkoutUI) = with(binding) {
            title.text = item.title
            type.text = context.resources.getText(item.type.text)
            duration.text = item.duration
            if (item.description.isNullOrBlank()) {
                description.visibility = android.view.View.GONE
            } else {
                description.text = item.description
                description.visibility = android.view.View.VISIBLE
            }

            root.setOnClickListener { listener.onWorkoutCardClick(item) }
        }
    }

    class WorkoutDiffCallback : DiffUtil.ItemCallback<WorkoutUI>() {
        override fun areItemsTheSame(oldItem: WorkoutUI, newItem: WorkoutUI): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: WorkoutUI, newItem: WorkoutUI): Boolean =
            oldItem == newItem
    }
}

