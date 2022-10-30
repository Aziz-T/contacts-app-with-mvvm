package com.tcorp.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.tcorp.contactsapp.R
import com.tcorp.contactsapp.databinding.FragmentRegisterContactBinding
import java.time.Duration


class RegisterContactFragment : Fragment() {
    private lateinit var registerContactBinding: FragmentRegisterContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        registerContactBinding = FragmentRegisterContactBinding.inflate(inflater,container, false)

        registerContactBinding.toolbarContact.title = "Kişi Kayıt"

        registerContactBinding.registerButton.setOnClickListener{

            val contactName = registerContactBinding.contactName.text.toString()
            val contactPhone = registerContactBinding.contactPhone.text.toString()

            registerContact(contactName,contactPhone)

        }


        return registerContactBinding.root
    }

   private fun registerContact(contactName : String, contactPhone: String){
        Log.d("message","$contactName - $contactPhone")
    }

}