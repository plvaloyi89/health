package com.example.pvaloyi.healthart


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.fragment_health_history.*


class health : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_health_history, container, false)

        val name = view.findViewById<EditText>(R.id.Fname)
        val LastName = view.findViewById<EditText>(R.id.Lname)
        val email = view.findViewById<EditText>(R.id.email)
        val phone = view.findViewById<EditText>(R.id.Pnumber)
        val age =view.findViewById<EditText>(R.id.age)
        val height = view.findViewById<EditText>(R.id.height)
        val weight = view.findViewById<EditText>(R.id.weight)
        val occupation = view.findViewById<EditText>(R.id.occupation)
        val button =view.findViewById<Button>(R.id.submit)

        button.setOnClickListener {


            val message = name.text.toString() +
            LastName.text.toString()+
            email.text.toString() +
            phone.text.toString() +
            age.text.toString() +
            height.text.toString() +
            weight.text.toString() +
            occupation.text.toString()

            val intent =Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL,"plvaloyi@gmail.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "health Tips")
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent,"Send form using" ))
        }




        return view
    }
    companion object {
        fun newInstance(): health = health()
    }

}
