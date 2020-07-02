package com.example.pvaloyi.healthart

import android.view.LayoutInflater

import android.content.Context

import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.fragment_home.view.*


class recipeAdapter(context: Context?, val layoutId:Int, val recipeArray:List<recipe>)
    :ArrayAdapter<recipe>(context,layoutId,recipeArray){



    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(layoutId, null)

        val Rimage = view.findViewById<ImageView>(R.id.recipe_Image)
        val lastname = view.findViewById<TextView>(R.id.recipe_name)
        val listOfRecipes = recipeArray[position]

       val downloadedUrl= listOfRecipes.item_pic

        if (downloadedUrl.isEmpty()) {
           // Rimage.setImageResource(R.mipmap.ic_placeholder_icon);
        } else{
            Picasso.
                get().
                load(downloadedUrl).
                resize(80,80).
                into(Rimage)
        }

        lastname.text = listOfRecipes.itemName



        return view

    }


}

