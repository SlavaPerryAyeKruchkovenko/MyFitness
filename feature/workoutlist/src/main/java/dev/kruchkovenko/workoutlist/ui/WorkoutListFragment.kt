package dev.kruchkovenko.workoutlist.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.chip.Chip
import dev.kruchkovenko.workoutlist.R
import dev.kruchkovenko.workoutlist.databinding.FragmentWorkoutListBinding
import dev.kruchkovenko.workoutlist.model.WorkoutListEvent
import dev.kruchkovenko.workoutlist.model.WorkoutListState
import dev.kruchkovenko.workoutlist.model.WorkoutTypeUI
import dev.kruchkovenko.workoutlist.model.WorkoutUI
import dev.kruchkovenko.workoutlist.presentation.WorkoutListViewModel
import dev.kruchkovenko.workoutlist.ui.decorator.VerticalSpaceItemDecoration
import dev.kruchkovenko.workoutlist.util.WorkoutListFragmentUtils.showEmpty
import dev.kruchkovenko.workoutlist.util.WorkoutListFragmentUtils.showError
import dev.kruchkovenko.workoutlist.util.WorkoutListFragmentUtils.showLoading
import dev.kruchkovenko.workoutlist.util.WorkoutListFragmentUtils.showWorkouts
import org.koin.androidx.viewmodel.ext.android.viewModel

class WorkoutListFragment : Fragment(), WorkoutListener {

    private lateinit var binding: FragmentWorkoutListBinding
    private val viewModel by viewModel<WorkoutListViewModel>()
    private val adapter = WorkoutListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkoutListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initWorkerRecycle()

        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is WorkoutListState.Loading -> binding.showLoading()
                is WorkoutListState.Display -> binding.showWorkouts(state, adapter)
                is WorkoutListState.Empty -> binding.showEmpty(requireContext())
                is WorkoutListState.Error -> binding.showError(state.message)
            }
        })
        viewModel.obtainEvent(WorkoutListEvent.Init)

        initSearchBar()
        setupChips()
    }

    private fun initWorkerRecycle() = with(binding.workouts) {
        adapter = this@WorkoutListFragment.adapter
        layoutManager = LinearLayoutManager(context)
        addItemDecoration(VerticalSpaceItemDecoration(12,requireContext()))
    }

    private fun initSearchBar() = with(binding.searchBar) {
        addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.obtainEvent(WorkoutListEvent.Search(s.toString()))
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun setupChips() {
        val chipGroup = binding.filterGroup
        chipGroup.removeAllViews()

        WorkoutTypeUI.entries.forEach { type ->
            val chip = layoutInflater.inflate(
                R.layout.item_chip_filter, chipGroup, false
            ) as Chip
            chip.setText(type.text)
            chip.isCheckable = true
            chip.tag = type
            chipGroup.addView(chip)
        }

        chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChip = checkedIds.firstOrNull()?.let { id ->
                group.findViewById<Chip>(id)?.tag as? WorkoutTypeUI
            } ?: WorkoutTypeUI.All

            viewModel.obtainEvent(WorkoutListEvent.Filter(selectedChip))
        }
    }

    override fun onWorkoutCardClick(workout: WorkoutUI) {
        Log.d(WorkoutListFragment::class.simpleName, workout.id.toString())
    }
}
