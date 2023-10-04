package com.example.fragments_aston

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragments_aston.databinding.FragmentBBinding

private const val ARG_PARAM1 = "param1"

class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)

        binding.goToFragmentC.setOnClickListener {

            val bundle = Bundle().apply { putString(ARG_PARAM1, "Hello Fragment C") }

            parentFragmentManager.commit {
                replace<FragmentC>(containerViewId = R.id.fragment_container, args = bundle)
                setReorderingAllowed(true)
                addToBackStack(FragmentC::class.java.simpleName)
            }
        }

        binding.back.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}