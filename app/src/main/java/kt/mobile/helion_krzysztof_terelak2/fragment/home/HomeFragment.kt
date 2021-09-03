package kt.mobile.helion_krzysztof_terelak2.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kt.mobile.helion_krzysztof_terelak2.adapters.CategoryAdapter
import kt.mobile.helion_krzysztof_terelak2.databinding.FragmentHomeBinding
import kt.mobile.helion_krzysztof_terelak2.util.ViewState
import kt.mobile.helion_krzysztof_terelak2.viewmodel.MainViewModel


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var mainViewModel: MainViewModel
    private val mAdapter by lazy { CategoryAdapter() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        setupRecyclerView()
        getAllCategories()


        return binding.root

    }


    private fun setupRecyclerView() {
        binding.recyclerview.adapter = mAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun getAllCategories() {
        mainViewModel.getAllCategories()
        mainViewModel.categoryResponse.observe(viewLifecycleOwner, { response ->
            when (response) {
                is ViewState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.errorTextView.visibility = View.GONE
                    binding.recyclerview.visibility = View.GONE
                }
                is ViewState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.errorTextView.visibility = View.GONE
                    binding.recyclerview.visibility = View.VISIBLE
                    response.data.let { mAdapter.setData(it) }
                }
                is ViewState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.errorTextView.visibility = View.VISIBLE
                    binding.recyclerview.visibility = View.GONE
                }
            }
        })
    }

}