package com.example.fragments_aston

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.fragments_aston.databinding.FragmentCBinding

private const val ARG_PARAM1 = "param1"

class FragmentC : Fragment() {
    private var param1: String? = null
    private var _binding: FragmentCBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCBinding.inflate(inflater, container, false)

        binding.goToFragmentD.setOnClickListener {
            parentFragmentManager.commit {
                replace<FragmentD>(R.id.fragment_container)
                setReorderingAllowed(true)
                addToBackStack(FragmentC::class.java.simpleName)
            }
        }

        binding.goToBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.helloFragmentCTv.text = param1
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}