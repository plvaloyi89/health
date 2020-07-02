package com.example.pvaloyi.healthart


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.picasso.Picasso


class shopAdapter(context: Context?, val layoutId:Int, val storeArray:List<shopStore>)
    : ArrayAdapter<shopStore>(context,layoutId,storeArray){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(layoutId, null)



        val image = view.findViewById<ImageView>(R.id.item_image)
        val name = view.findViewById<TextView>(R.id.item_name)
        val desc = view.findViewById<TextView>(R.id.item_desc)
        val price= view.findViewById<TextView>(R.id.item_price)
        val button  =  view.findViewById<Button>(R.id.button_Purchase)
        val shopList = storeArray[position]
        val dbHandler : databaseHelper? = null



        button.setOnClickListener {

            val product = orderCart( shopList.item_pic,shopList.itemName ,shopList.itemDesc,shopList.itemPrice.toFloat())
            if (dbHandler != null) {
                dbHandler.writableDatabase
                dbHandler.add(product)

            }

        }


        val downloadedUrl= shopList.item_pic

        val mPicasso = Picasso.get()
        mPicasso.setIndicatorsEnabled(true)



        if (downloadedUrl.isEmpty()) {
            // Rimage.setImageResource(R.mipmap.ic_placeholder_icon);
        } else{
            Picasso.
                get().
                load(downloadedUrl).
                resize(80,80).
                into(image)
        }

        name.text = shopList.itemName
        desc.text = shopList.itemDesc
       price.text= shopList.itemPrice




        return view




    }




}






