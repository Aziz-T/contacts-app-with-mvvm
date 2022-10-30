package com.tcorp.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        registerDetailBinding = FragmentRegisterDetailBinding.inflate(inflater,container,false)

        registerDetailBinding.toolbarDetail.title = "Kişi Kayıt"

        val bundle : RegisterDetailFragmentArgs by navArgs()


        registerDetailBinding.contactName.setText(bundle.contact.contact_name)
        registerDetailBinding.contactPhone.setText(bundle.contact.contact_phone)


        registerDetailBinding.updateButton.setOnClickListener{

            val contactName = registerDetailBinding.contactName.text.toString()
            val contactPhone = registerDetailBinding.contactPhone.text.toString()

            updateContact(bundle.contact.contact_id,contactName,contactPhone)

        }


        return registerDetailBinding.root
    }

    private fun updateContact(contactId:Int, contactName : String, contactPhone: String){
        Log.d("message","$contactName - $contactPhone")
    }

}