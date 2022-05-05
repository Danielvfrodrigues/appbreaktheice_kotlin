package br.com.bravi.breaktheice.presentation.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bravi.breaktheice.databinding.FragmentActivityDetailBinding
import br.com.bravi.breaktheice.util.TimerHelper
import java.util.*

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class ActivityDetailFragment() : BaseFragment() {

    lateinit var binding: FragmentActivityDetailBinding
    lateinit var timerHelper: TimerHelper
    private val timer = Timer()
    var startTime: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        bundle: Bundle?,
    ): View {
        binding = FragmentActivityDetailBinding.inflate(layoutInflater)
        binding.lifecycleOwner = requireActivity()

        timerHelper = TimerHelper(requireContext())

        binding.detailAccessibilityTextView.text = "$id"

        binding.startButton.setOnClickListener { startAction() }
        binding.finishButton.setOnClickListener { finishAction() }
        binding.cancelButton.setOnClickListener { cancelAction() }

        if (timerHelper.timerCounting()) {
            startTimer()
        } else {
            stopTimer()
            if (timerHelper.startTime() != null && timerHelper.stopTime() != null)
            {
                val time = Date().time
                binding.detailTimeTextView.text = timeStringFromLong(time)
            }
        }

        timer.scheduleAtFixedRate(TimeTask(), 0, 500)

        fetchResult()

        val id = requireArguments().getInt(ARGUMENT_ACTIVITY_MODEL_ID)
        viewModel.getActivity(id)

        return binding.root
    }

    private inner class TimeTask: TimerTask()
    {
        override fun run() {
            if (timerHelper.timerCounting())
            {
                val time = Date().time - timerHelper.startTime()!!.time
                binding.detailTimeTextView.text = timeStringFromLong(time)
            }
        }
    }

    private fun startAction() {
        if (timerHelper.timerCounting())
        {
            timerHelper.setStopTime(Date())
            stopTimer()
        }
        else
        {
            if (timerHelper.stopTime() != null)
            {
                timerHelper.setStopTime(null)
            }
            else
            {
                timerHelper.setStartTime(Date())
            }
            startTime = Date().time

            val startTimeInMillis = Date().time
            val startTime =  timeStringFromLong(startTimeInMillis).toString()
            viewModel.updateStartTime(startTime)

            startTimer()
        }

        binding.startButton.visibility = View.GONE
        binding.finishButton.visibility = View.VISIBLE
        binding.cancelButton.visibility = View.VISIBLE
    }

    private fun finishAction() {
        if (timerHelper.timerCounting()) {
            timerHelper.setStopTime(Date())
            stopTimer()

            val finishTimeInMillis = Date().time
            val finishTime =  timeStringFromLong(finishTimeInMillis).toString()
            viewModel.updateFinishTime(finishTime)

            binding.startButton.visibility = View.VISIBLE
            binding.startButton.isEnabled = false
            binding.startButton.text = "Activity Finished"
            binding.finishButton.visibility = View.GONE
            binding.cancelButton.visibility = View.GONE

            binding.activityCompletedCheck.visibility = View.VISIBLE
        }
    }

    private fun cancelAction() {
        timerHelper.setStartTime(null)
        timerHelper.setStopTime(null)
        stopTimer()
        binding.detailTimeTextView.text = timeStringFromLong(0)

        binding.startButton.visibility = View.VISIBLE
        binding.finishButton.visibility = View.GONE
        binding.cancelButton.visibility = View.GONE
    }

    private fun stopTimer() {
        timerHelper.setTimerCounting(false)
    }

    private fun startTimer() {
        timerHelper.setTimerCounting(true)
    }

    private fun timeStringFromLong(ms: Long): String? {
        val seconds = (ms / 1000) % 60
        val minutes = (ms / 1000 * 60) % 60
        val hours = (ms / 1000 * 60 * 60) % 24

        return makeTimeString(hours, minutes, seconds)
    }

    private fun makeTimeString(hours: Long, minutes: Long, seconds: Long): String? {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

    private fun fetchResult() {
        viewModel.activity.observe(viewLifecycleOwner) { res ->
            if (res != null) {
                Log.d(ActivityDetailFragment.TAG, res.toString())
            }
        }
    }

    companion object {

        private const val TAG: String = "ActivityDetailFragment"

        const val ARGUMENT_ACTIVITY_MODEL_ID: String = "activityId"

        fun getInstance(bundle: Bundle?): ActivityDetailFragment {
            val activityDetailFragment = ActivityDetailFragment()
            activityDetailFragment.arguments = bundle

            return activityDetailFragment
        }
    }
}