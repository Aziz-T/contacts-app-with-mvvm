package com.tcorp.contactsapp.ui.adapters

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.tcorp.contactsapp.R
import com.tcorp.contactsapp.data.entity.Contacts
import com.tcorp.contactsapp.databinding.CardItemBinding
import com.tcorp.contactsapp.ui.fragment.MainPageFragmentDirections

class ContactListAdapter(var mContext: Context, var contactList:List<Contacts>):
    RecyclerView.Adapter<ContactListAdapter.CardDesignHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val cardBinding:CardItemBinding= DataBindingUtil.inflate(layoutInflater,
            R.layout.card_item,parent,false)
        return CardDesignHolder(cardBinding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val t = holder.binding
        val item = contactList.get(position)
        t.contactModel = item


        t.cardView.setOnClickListener{
            val navigator = MainPageFragmentDirections.actionMainPageFragmentToRegisterDetailFragment(item)
            Navigation.findNavController(it).navigate(navigator)
        }


        t.imageViewDelete.setOnClickListener{
            Snackbar.make(it,"${item.contact_name} kişisi silinsin mi?",Snackbar.LENGTH_INDEFINITE)
                .setBackgroundTint(Color.BLUE).setAction("Evet"){
                Log.d("Silindi",item.contact_id.toString())
            }.show()
        }

    }

    override fun getItemCount(): Int {
       return contactList.size
    }

    inner class CardDesignHolder(itemBinding: CardItemBinding):RecyclerView.ViewHolder(itemBinding.root){
        var binding: CardItemBinding
        init {
            this.binding = itemBinding
        }


    }
}