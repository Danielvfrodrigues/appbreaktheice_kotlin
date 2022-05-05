package br.com.bravi.breaktheice.presentation.fragment

import androidx.fragment.app.Fragment
import br.com.bravi.breaktheice.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
open class BaseFragment : Fragment() {

    protected val fragmentActivity by lazy {
        requireActivity()
    }
    protected val viewModel by sharedViewModel<MainViewModel>()
}
