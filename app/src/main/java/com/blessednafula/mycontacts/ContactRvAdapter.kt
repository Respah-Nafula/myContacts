package com.blessednafula.mycontacts

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blessednafula.mycontacts.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso

class ContactRvAdapter(var contactList: List<Contact>) : RecyclerView.Adapter<ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var currentContact = contactList.get(position)
        holder.binding.tvName.text = currentContact.name
        holder.binding.tvAdress.text = currentContact.address
        holder.binding.tvEmail1.text = currentContact.email
         Picasso.get().load(currentContact.image)
             .resize(300,300)
             .centerCrop()
             .placeholder(R.drawable.ic_baseline_person_24)
             .into(holder.binding.imvContact)


    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

class ContactViewHolder(val binding: ContactListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {


}



