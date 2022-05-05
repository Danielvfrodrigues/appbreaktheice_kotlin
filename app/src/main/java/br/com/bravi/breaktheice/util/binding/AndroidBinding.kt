package br.com.bravi.breaktheice.util.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import br.com.bravi.breaktheice.util.GeneralUtil.getAccessibilityText

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
object AndroidBinding {

    @JvmStatic
    @BindingAdapter("app:accessibilityText")
    fun TextView.setAccessibilityText(accessibility: Float) {
        text = context.getAccessibilityText(accessibility)
    }
}
