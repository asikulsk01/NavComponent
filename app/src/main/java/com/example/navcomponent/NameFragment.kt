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
import com.example.navcomponent.databinding.FragmentNameBinding



class NameFragment : Fragment() {
    lateinit var binding: FragmentNameBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_name,container,false)

        //When click on submit button.
        binding.btnSubmit.setOnClickListener {
            //For taking the name from editText
            val name = binding.etName.text.toString()
            //set the data to the bundle ibj
            val bundle = bundleOf("UserName" to name)
            //transfer the bundle obj to the next fragment

            if (name.isNotEmpty()){
                //Null check name should not be empty.
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment,bundle)
            }else{
                Toast.makeText(activity,"Enter name",Toast.LENGTH_SHORT).show()
            }


        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_name, container, false)
    }
}