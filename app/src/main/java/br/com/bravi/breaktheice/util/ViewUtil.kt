package br.com.bravi.breaktheice.util

import android.content.Context
import android.content.res.Configuration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
object ViewUtil {

    private fun Context.isOrientationPortrait(): Boolean {
        return resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
    }

    @JvmOverloads
    fun RecyclerView.createAdapter(
        context: Context,
        viewAdapter: RecyclerView.Adapter<*>,
        itemDecoration: ItemDecoration? = null,
        orientation: Int = RecyclerView.VERTICAL
    ) {
        val linearLayoutManager = LinearLayoutManager(context, orientation, false)
        val gridLayoutManager = GridLayoutManager(context, 2)
        adapter = viewAdapter
        layoutManager = if (context.isOrientationPortrait()) {
            linearLayoutManager
        } else {
            gridLayoutManager
        }

        layoutManager

        setHasFixedSize(false)

        if (itemDecoration != null) {
            addItemDecoration(itemDecoration)
        }
    }
}
