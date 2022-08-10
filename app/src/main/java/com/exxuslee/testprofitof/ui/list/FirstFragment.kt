package com.exxuslee.testprofitof.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.exxuslee.testprofitof.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class FirstFragment : Fragment() {

    private val viewModelFirst: FistFragmentViewModel by viewModel()
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private lateinit var firstAdapter: FirstAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        viewModelFirst.remoteList()
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firstAdapter = FirstAdapter()
        binding.recyclerView.adapter = firstAdapter

        viewModelFirst.dataFetchState.observe(viewLifecycleOwner) { state ->
            if (!state) {
                binding.errorText.visibility = View.VISIBLE
                Snackbar.make(requireView(),
                    "Oops! An error occured, check your connection and retry!",
                    Snackbar.LENGTH_LONG).show()
            }
        }

        viewModelFirst.ids.observe(viewLifecycleOwner) { list ->
            firstAdapter.updateAdapter(list)
        }

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}