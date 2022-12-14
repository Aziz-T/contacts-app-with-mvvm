package com.tcorp.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.tcorp.contactsapp.R
import com.tcorp.contactsapp.databinding.FragmentRegisterContactBinding
import com.tcorp.contactsapp.databinding.FragmentRegisterDetailBinding


class RegisterDetailFragment : Fragment() {

    private lateinit var registerDetailBinding: FragmentRegisterDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        registerDetailBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_register_detail,container,false)

        registerDetailBinding.contactDetailFragment = this
        registerDetailBinding.contactDetailToolbarTitle = "Kişi Detay"

        val bundle : RegisterDetailFragmentArgs by navArgs()
        registerDetailBinding.contactModel = bundle.contact


        return registerDetailBinding.root
    }

     fun updateContact(contactId:Int, contactName : String, contactPhone: String){
        Log.d("message","$contactName - $contactPhone")
    }

}