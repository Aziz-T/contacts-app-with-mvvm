package com.tcorp.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tcorp.contactsapp.R
import com.tcorp.contactsapp.databinding.FragmentRegisterContactBinding
import java.time.Duration


class RegisterContactFragment : Fragment() {
    private lateinit var registerContactBinding: FragmentRegisterContactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        registerContactBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_register_contact,container, false)
        registerContactBinding.contactRegisterFragment = this
        registerContactBinding.registerContactToolbarTitle = "Kişi Kayıt"




        return registerContactBinding.root
    }

    fun registerContact(contactName : String, contactPhone: String){
        Log.d("message","$contactName - $contactPhone")
    }

}