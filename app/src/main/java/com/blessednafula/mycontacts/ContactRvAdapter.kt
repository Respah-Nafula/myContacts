package com.blessednafula.mycontacts

import android.app.ProgressDialog.show
import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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
        val context=holder.itemView.context
        holder.binding.imvContact.setOnClickListener(){
            Toast
                .makeText(context,"You have clicked the image",Toast.LENGTH_SHORT)
            .show()
        }
        holder.binding.cvContact.setOnClickListener(){
            val intent=Intent(context,ViewContactActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("ADDRESS",currentContact.address)
            intent.putExtra("MAIL",currentContact.email)
            intent.putExtra("MOBILE",currentContact.phoneNumber)
            intent.putExtra("IMAGE",currentContact.image)
            context.startActivity(intent)
            holder.binding.imvContact.setOnClickListener{
                Toast.makeText(context, "you have clicked my face", Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}

class ContactViewHolder(val binding: ContactListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
}



