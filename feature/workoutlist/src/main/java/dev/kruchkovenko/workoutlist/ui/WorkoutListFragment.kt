package dev.kruchkovenko.workoutlist.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dev.kruchkovenko.workoutlist.databinding.FragmentWorkoutListBinding
import dev.kruchkovenko.workoutlist.model.WorkoutUI
import dev.kruchkovenko.workoutlist.presentation.WorkoutListViewModel

class WorkoutListFragment : Fragment(), WorkoutListener {
    private lateinit var binding: FragmentWorkoutListBinding
    private val viewModel by viewModels<WorkoutListViewModel>()
    private val adapter = WorkoutListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkoutListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onWorkoutCardClick(workout: WorkoutUI) {
        Log.d("WorkoutListFragment", workout.id.toString())
    }
}
