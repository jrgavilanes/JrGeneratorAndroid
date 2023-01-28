package es.codekai.jrgeneratorandroid.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import es.codekai.jrgeneratorandroid.R
import es.codekai.jrgeneratorandroid.databinding.FragmentNameBinding

class NameFragment : Fragment() {
    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.btnNext.setOnClickListener {
            if (!binding.edName.text.isNullOrEmpty()) {
                val action = NameFragmentDirections.actionNameFragmentToEmailFragment(
                    name = binding.edName.text.toString()
                )

                it.findNavController().navigate(action)
            } else {
                Toast.makeText(context, "Enter your name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
