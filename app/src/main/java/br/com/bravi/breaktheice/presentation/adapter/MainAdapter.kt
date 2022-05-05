package br.com.bravi.breaktheice.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils.loadAnimation
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.bravi.breaktheice.R
import br.com.bravi.breaktheice.databinding.ItemActivityBinding
import br.com.bravi.breaktheice.domain.entity.ActivityModel

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class MainAdapter(
        private val fragmentActivity: FragmentActivity,
        val onItemClickListener: (ActivityModel?) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>(), IItemContract<ActivityModel> {

    private var activityModelDataSet: List<ActivityModel?> = listOf()
    private var index: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemActivityBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activityModel: ActivityModel? = activityModelDataSet[position]
        holder.bind(activityModel)
        holder.onItemClick(activityModel)

        if (position > index) {
            holder.startAnimation(position)
        }
    }

    override fun getItemCount(): Int {
        return activityModelDataSet.size
    }

    override fun replaceList(dataSet: MutableList<ActivityModel?>, init: Boolean) {
        activityModelDataSet = dataSet
        if (init) {
            activityModelDataSet = dataSet
        }
        index = -1

        notifyDataSetChanged()
    }

    private fun ViewHolder.onItemClick(activityModel: ActivityModel?) {
        itemView.findViewById<RelativeLayout>(R.id.activity_layout).setOnClickListener {
            onItemClickListener(activityModel)
        }
    }

    private fun ViewHolder.startAnimation(position: Int) {
        val animation: Animation = loadAnimation(fragmentActivity, android.R.anim.fade_in)
        itemView.startAnimation(animation)
        index = position
    }

    inner class ViewHolder(
            private val binding: ItemActivityBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(activityModel: ActivityModel?) {
            binding.activityModel = activityModel
            binding.executePendingBindings()
        }
    }
}
