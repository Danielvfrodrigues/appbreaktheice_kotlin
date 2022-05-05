package br.com.bravi.breaktheice.util

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import br.com.bravi.breaktheice.R

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
object ActivityUtil {

    fun FragmentManager.addFragment(
        fragment: Fragment,
        @IdRes viewId: Int
    ) {
        beginTransaction()
            .add(viewId, fragment)
            .commit()
    }

    fun FragmentManager.replaceFragment(
        fragment: Fragment,
        animationArr: IntArray = intArrayOf(
            R.anim.slide_in_right, R.anim.slide_out_left,
            R.anim.slide_in_left, R.anim.slide_out_right
        ),
        @IdRes viewId: Int
    ) {
        beginTransaction()
            .setCustomAnimations(
                animationArr[0], animationArr[1],
                animationArr[2], animationArr[3]
            )
            .replace(viewId, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun popBackStack(fragmentManager: FragmentManager) {
        fragmentManager.popBackStack()
    }
}
