package br.com.bravi.breaktheice.util

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AlertDialog
import br.com.bravi.breaktheice.R
import br.com.bravi.breaktheice.presentation.activity.MainActivity
import okhttp3.internal.Internal.instance

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
