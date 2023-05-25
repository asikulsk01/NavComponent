package com.example.navcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navcomponent.databinding.FragmentEmailBinding


class EmailFragment : Fragment() {
    lateinit var binding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_email, container, false)


        //When click on SignUp button
        binding.btnSubmit.setOnClickListener {
            //taking the data from previous fragment and null checking so that blank data should pass.
            val name = requireArguments().getString("UserName")
            val email = binding.etEmail.text.toString()

            //Make bundle list
            val bundle = bundleOf("UserName" to name, "UserEmail" to email)

            if (email.isNotEmpty()){
                //transfer the control to next fragment with the data
                it.findNavController().navigate(R.id.action_emailFragment_to_welcomeFragment,bundle)
            }else{
                Toast.makeText(activity,"Enter email", Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }

}