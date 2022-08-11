package com.exxuslee.testprofitof.ui.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.exxuslee.testprofitof.databinding.FragmentThirdBinding
import com.exxuslee.testprofitof.ui.MainViewModel
import com.exxuslee.testprofitof.utils.showIf
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val viewModel by sharedViewModel<MainViewModel>()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.web.webViewClient = MyWebViewClient()
        true.also { binding.web.settings.javaScriptEnabled = it }

        viewModel.dataFetchState.observe(viewLifecycleOwner) { state ->
            if (!state) {
                binding.errorText.visibility = View.VISIBLE
                Snackbar.make(requireView(),
                    "Oops! An error occured, check your connection and retry!",
                    Snackbar.LENGTH_LONG).show()
            }
        }
        binding.web.loadUrl(arguments?.getString("content").toString())
        viewModel.isLoading.observe(viewLifecycleOwner) { state ->
            binding.progressBar.showIf { state }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}