package br.com.bravi.breaktheice.util

import android.content.Context
import br.com.bravi.breaktheice.R

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
object GeneralUtil {

    fun Context.getAccessibilityText(accessibility: Float): String {
        return when (accessibility) {
            in 0.0..3.3 -> {
                getString(R.string.label_accessibility_easy)
            }
            in 3.3..6.6 -> {
                getString(R.string.label_accessibility_medium)
            }
            else -> {
                getString(R.string.label_accessibility_hard)
            }
        }
    }
}
