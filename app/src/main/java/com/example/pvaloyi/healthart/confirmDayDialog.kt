package com.example.pvaloyi.healthart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.bookday.*
import java.util.*


class confirmDayDialog : AppCompatActivity() {
    private lateinit var database: DatabaseReference
// ...


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bookday)

        val editname = findViewById<EditText>(R.id.getName)
        val editemail = findViewById<EditText>(R.id.getEmail)
        val editphoneNum = findViewById<EditText>(R.id.getPhoneNumber)
        val cancel = findViewById<Button>(R.id.cancel)
        val confirm = findViewById<Button>(R.id.book)


        displayDay.text= intent.extras.getString("day")
        val seton  =displayDay

        confirm.setOnClickListener {

            val name = editname.text.toString().trim()
            val email = editemail.text.toString()
            val phone = editphoneNum.text.toString()
            val day = seton.text.toString()


            database = FirebaseDatabase.getInstance().getReference("bookDay")
            val bookId = database.push().key

            val calendar = calendar(bookId.toString(),name,email,phone,day)

            if(name.isEmpty()){
                editname.error = "There is an error"
                return@setOnClickListener
            }

            if(email.isEmpty()){
                editemail.error = "There is an error"
                return@setOnClickListener
            }

            if(phone.isEmpty()){
                editphoneNum.error = "There is an error"
                return@setOnClickListener
            }


            database.child(bookId!!).setValue(calendar).addOnCompleteListener {
                Toast.makeText(applicationContext,"your booking is saved", Toast.LENGTH_SHORT).show()
                finish()
            }

        }


        cancel.setOnClickListener {
            finish()
        }
    }
}