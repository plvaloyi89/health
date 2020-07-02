package com.example.pvaloyi.healthart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.bookday.view.*
import kotlinx.android.synthetic.main.cart_list.*

class shoppingCart : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_list)
        val dbHandler : databaseHelper? = null
       // val dbHandler = databaseHelper(this, null)

//        val product = dbHandler?.findProduct()
//
//        if (product != null) {
//            prodName.text = product.itemName
//
//            desc.setText(
//                product.itemDesc.toString())
//        } else {
//            prodName.text = "No Match Found"
//        }







    }
}
