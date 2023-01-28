package es.codekai.jrgeneratorandroid.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import es.codekai.jrgeneratorandroid.R
import es.codekai.jrgeneratorandroid.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    private val args: WelcomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        setupListeners()
        setupUI()
        return binding.root
    }

    private fun setupUI() {
        binding.apply {
            txtTitle.text = "Welcome ${args.name}\n\nyour email ${args.email} has been setup"
        }
    }

    private fun setupListeners() {
        binding.btnViewTerms.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeFragmentToTermsFragment()
            it.findNavController().navigate(action)
        }
    }
}
