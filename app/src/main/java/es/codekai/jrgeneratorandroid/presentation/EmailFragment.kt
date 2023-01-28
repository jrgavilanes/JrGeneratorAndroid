package es.codekai.jrgeneratorandroid.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import es.codekai.jrgeneratorandroid.R
import es.codekai.jrgeneratorandroid.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding
    private val args: EmailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        Log.d("janrax", "llega name: ${args.name}")
        setupListeners()
        return binding.root
    }

    private fun setupListeners() {
        binding.btnNext.setOnClickListener {
            if (!binding.edEmail.text.isNullOrEmpty()) {
                val action = EmailFragmentDirections.actionEmailFragmentToWelcomeFragment(
                    name = args.name,
                    email = binding.edEmail.text.toString()
                )
                it.findNavController().navigate(action)
            } else {
                Toast.makeText(context, "Enter your email", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
