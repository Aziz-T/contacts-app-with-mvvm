package com.tcorp.contactsapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcorp.contactsapp.R
import com.tcorp.contactsapp.data.entity.Contacts
import com.tcorp.contactsapp.databinding.FragmentMainPageBinding
import com.tcorp.contactsapp.ui.adapters.ContactListAdapter


class MainPageFragment : Fragment(),SearchView.OnQueryTextListener {

    private lateinit var mainPageBinding: FragmentMainPageBinding
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
        mainPageBinding = FragmentMainPageBinding.inflate(inflater,container,false )

        mainPageBinding.toolbarMainPage?.title = "Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(mainPageBinding.toolbarMainPage)

        mainPageBinding.recyclerView?.layoutManager = LinearLayoutManager(requireContext())

        val contactList = ArrayList<Contacts>()
        contactList.add(Contacts(1,"Ahmet","53435345434"))
        contactList.add(Contacts(1,"Ahmet","53435345434"))
        contactList.add(Contacts(1,"Ahmet","53435345434"))
        contactList.add(Contacts(1,"Ahmet","53435345434"))
        contactList.add(Contacts(1,"Ahmet","53435345434"))

        val adapter = ContactListAdapter(requireContext(),contactList)
        mainPageBinding.recyclerView?.adapter = adapter




        mainPageBinding.floatingActionButton?.setOnClickListener {

            Log.d("button basma ", "lol")
            Navigation.findNavController(it).navigate(R.id.action_mainPageFragment_to_registerContactFragment)

         }


        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
               menuInflater.inflate(R.menu.toolbar_menu,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                if (menuItem.itemId == R.id.search_menu){
                    val searchView = menuItem.actionView as SearchView
                    searchView.setOnQueryTextListener(this@MainPageFragment)
                }
                return true
            }

        })



        return mainPageBinding.root
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
       searchContact(p0)
        return true
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        searchContact(p0)
        return true
    }

    private fun searchContact(text:String?){
        Log.d("arama kelimesi", text?:"")
    }

    override fun onResume() {
        super.onResume()

    }

}