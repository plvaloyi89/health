package com.example.pvaloyi.healthart


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.shoplist.*
import kotlinx.android.synthetic.main.shoplist.view.*


class Shop : Fragment() {

    lateinit var ref : DatabaseReference
    lateinit var listOfProducts:MutableList<shopStore>
    lateinit var listview:ListView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view: View = inflater.inflate(R.layout.fragment_shop, container, false)

        listOfProducts = mutableListOf()
        listview = view.findViewById(R.id.store_shop)
        ref = FirebaseDatabase.getInstance().getReference("shop")

        val mfab = view.findViewById<FloatingActionButton>(R.id.fab)

         ref.addValueEventListener(object : ValueEventListener {

            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context, "sorry", Toast.LENGTH_LONG).show()

            }

            override fun onDataChange(p0: DataSnapshot) {

                val adapter = shopAdapter(context, R.layout.shoplist, listOfProducts)
                if (p0.exists()) {
                    listOfProducts.clear()
                    for (e in p0.children) {
                        val products = e.getValue(shopStore::class.java)
                        listOfProducts.add(products!!)

                    }


                    listview.adapter = adapter

                    mfab.setOnClickListener {
                        val shop = Intent(context, shoppingCart::class.java)
                        startActivity(shop)
                    }


                }



                }






        })



        return view


    }

    companion object {
        fun newInstance(): Shop = Shop()
    }



}
