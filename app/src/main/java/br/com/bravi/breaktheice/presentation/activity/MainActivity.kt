package br.com.bravi.breaktheice.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import br.com.bravi.breaktheice.databinding.ActivityMainBinding
import br.com.bravi.breaktheice.presentation.fragment.ActivityListFragment
import br.com.bravi.breaktheice.presentation.viewmodel.MainViewModel
import br.com.bravi.breaktheice.util.ActivityUtil.addFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class MainActivity : FragmentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner = this@MainActivity
        binding.viewModel = viewModel

        supportFragmentManager.addFragment(
            ActivityListFragment.getInstance(null),
            binding.container.id
        )

        fetchError()
    }

    private fun fetchError() {
        viewModel.error.observe(this@MainActivity) { err ->
            if (err != null) {
                Log.e(TAG, "${err.message}")
            }
        }
    }

    companion object {

        private const val TAG: String = "MainActivity"
    }
}
