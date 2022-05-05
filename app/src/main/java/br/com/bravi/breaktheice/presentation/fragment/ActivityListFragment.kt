package br.com.bravi.breaktheice.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.bravi.breaktheice.R
import br.com.bravi.breaktheice.databinding.FragmentActivityListBinding
import br.com.bravi.breaktheice.domain.entity.ActivityModel
import br.com.bravi.breaktheice.presentation.adapter.MainAdapter
import br.com.bravi.breaktheice.presentation.fragment.ActivityDetailFragment.Companion.ARGUMENT_ACTIVITY_MODEL_ID
import br.com.bravi.breaktheice.util.ActivityUtil.replaceFragment
import br.com.bravi.breaktheice.util.ViewUtil.createAdapter

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class ActivityListFragment : BaseFragment() {

    private val mainAdapter by lazy {
        MainAdapter(fragmentActivity) { activityModel ->
            val bundle = Bundle()
            bundle.putInt(ARGUMENT_ACTIVITY_MODEL_ID, activityModel?._id ?: 0)

            val fragmentManager = fragmentActivity.supportFragmentManager
            fragmentManager.replaceFragment(
                    ActivityDetailFragment.getInstance(bundle),
                    viewId = R.id.container
            )
        }
    }

    private val activities: MutableList<ActivityModel?> = arrayListOf()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            bundle: Bundle?
    ): View {
        val binding = FragmentActivityListBinding.inflate(layoutInflater)
        binding.lifecycleOwner = requireActivity()
        binding.viewModel = viewModel
        binding.newActivityFab.setOnClickListener {
            val fragmentManager = fragmentActivity.supportFragmentManager
            val activityFilterFragment = ActivityFilterFragment()
            activityFilterFragment.show(fragmentManager)
        }
        binding.recyclerView.createAdapter(fragmentActivity.applicationContext, mainAdapter)

        fetchResult()

        viewModel.getActivities()

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun fetchResult() {
        viewModel.activities.observe(viewLifecycleOwner) { res ->
            if (res != null) {
                mainAdapter.replaceList(res.toMutableList(), true)
            }
        }
    }

    companion object {

        fun getInstance(bundle: Bundle?): ActivityListFragment {
            val activityListFragment = ActivityListFragment()
            activityListFragment.arguments = bundle

            return activityListFragment
        }
    }
}
