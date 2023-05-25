package com.example.navcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.navcomponent.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome, container, false)
        // inflater.inflate(R.layout.fragment_welcome, container, false)

        //Fetch the Name and Email
        val name = arguments?.getString("UserName")
        val email = arguments?.getString("UserEmail")

        binding.tvName.text = name
        binding.tvEmail.text = email

        //When click on terms button
        binding.btnTerms.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_termsFragment)
        }

        return binding.root
    }

}