package es.codekai.jrgeneratorandroid.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import es.codekai.jrgeneratorandroid.R
import es.codekai.jrgeneratorandroid.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.btnSignUp.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToNameFragment()
            it.findNavController().navigate(action)
        }

        binding.btnTerms.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToTermsFragment()
            it.findNavController().navigate(action)
        }
    }
}
