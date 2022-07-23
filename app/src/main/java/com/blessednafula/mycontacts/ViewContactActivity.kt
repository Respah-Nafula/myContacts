package com.blessednafula.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.blessednafula.mycontacts.databinding.ActivityViewContactBinding
import com.blessednafula.mycontacts.databinding.ContactListItemBinding
import com.squareup.picasso.Picasso

class ViewContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityViewContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityViewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }
    fun  getExtras(){
        var name=intent.extras?.getString("NAME")
        var address=intent.extras?.getString("ADDRESS")
        var person=intent.extras?.getString("NAME")
        var mobile=intent.extras?.getString("MOBILE")
        var mail=intent.extras?.getString("MAIL")
        var image = binding.imgPerson


        Toast.makeText(this,name,Toast.LENGTH_LONG).show()
        Toast.makeText(this,person,Toast.LENGTH_LONG).show()

        binding.tvPerson.text=name
        binding.tvMobile.text=mobile
        binding.tvMail.text=mail
        binding.tvPerson.text=person
        Picasso.get().load(intent.getStringExtra("IMAGE")).into(image)
    }
}
