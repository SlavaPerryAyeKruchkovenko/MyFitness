package dev.kruchkovenko.workoutdetails.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.media3.exoplayer.ExoPlayer
import dev.kruchkovenko.core.extension.BundleExtension.parsable
import dev.kruchkovenko.core.model.WorkoutUI
import dev.kruchkovenko.workoutdetails.databinding.FragmentWorkoutDetailsBinding
import dev.kruchkovenko.workoutdetails.model.WorkoutDetailsEvent
import dev.kruchkovenko.workoutdetails.model.WorkoutDetailsState
import dev.kruchkovenko.workoutdetails.presentation.WorkoutDetailsViewModel
import dev.kruchkovenko.workoutdetails.util.WorkoutDetailsFragmentUtils.showError
import dev.kruchkovenko.workoutdetails.util.WorkoutDetailsFragmentUtils.showLoading
import dev.kruchkovenko.workoutdetails.util.WorkoutDetailsFragmentUtils.showWorkoutDetails
import org.koin.androidx.viewmodel.ext.android.viewModel

class WorkoutDetailsFragment : Fragment() {

    private lateinit var _binding: FragmentWorkoutDetailsBinding
    private val binding get() = _binding

    private val viewModel: WorkoutDetailsViewModel by viewModel<WorkoutDetailsViewModel>()

    private var player: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkoutDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBackButton()
        observeState()
        val workout = requireArguments().parsable<WorkoutUI>("workout")
        workout?.also {
            viewModel.obtainEvent(WorkoutDetailsEvent.Init(it))
        }
    }

    private fun initBackButton() = with(binding) {
        backButton.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun observeState() = with(binding) {
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is WorkoutDetailsState.Loading -> showLoading()
                is WorkoutDetailsState.Display -> {
                    this@WorkoutDetailsFragment.player = showWorkoutDetails(state, requireContext())
                }

                is WorkoutDetailsState.Error -> showError(state.message)
                else -> {}
            }
        })
    }

    override fun onStop() {
        super.onStop()
        player?.release()
    }

    override fun onDestroy() {
        super.onDestroy()
        player = null
    }
}
