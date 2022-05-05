package br.com.bravi.breaktheice.presentation.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import br.com.bravi.breaktheice.R
import br.com.bravi.breaktheice.databinding.FragmentActivityFilterBinding
import br.com.bravi.breaktheice.presentation.viewmodel.MainViewModel
import br.com.bravi.breaktheice.util.constant.WebserviceConstant.WEBSERVICE_QUERY_TYPE
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.Locale.ROOT

/**
 * @author Daniel Rodrigues
 * "Sometimes I believe the compiler ignores all my comments."
 */
class ActivityFilterFragment : DialogFragment() {

    fun show(fragmentManager: FragmentManager) {
        if (fragmentManager.findFragmentByTag(TAG) == null) {
            show(fragmentManager, TAG)
        }
    }

    private val activityTypeArr by lazy {
        resources.getStringArray(R.array.activity_type_array)
    }
    private val viewModel by sharedViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        bundle: Bundle?
    ): View {
        val binding = FragmentActivityFilterBinding.inflate(layoutInflater)
        binding.lifecycleOwner = requireActivity()
        binding.viewModel = viewModel
        binding.searchButton.setOnClickListener {
            val queries: MutableMap<String, String> = mutableMapOf()
            val activityTypeStr = binding.typeAutoCompleteTextView.text.toString()
            if (activityTypeStr.equals(activityTypeArr[0], ignoreCase = true)) {
                viewModel.doActivity()
            } else {
                queries[WEBSERVICE_QUERY_TYPE] = activityTypeStr.lowercase(ROOT)
                viewModel.doActivityFiltered(queries)
            }

            dismiss()
        }

        val context = requireContext()
        val arrayAdapter = ArrayAdapter(context, R.layout.dropdown_item, activityTypeArr)
        binding.typeAutoCompleteTextView.setAdapter(arrayAdapter)

        return binding.root
    }

    override fun onCreateDialog(bundle: Bundle?): Dialog {
        setStyle(STYLE_NORMAL, R.style.Theme_Dialog)

        return super.onCreateDialog(bundle)
    }

    companion object {

        private const val TAG: String = "ActivityFilterFragment"
    }
}