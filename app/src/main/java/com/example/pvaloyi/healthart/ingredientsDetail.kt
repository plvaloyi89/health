package com.example.pvaloyi.healthart

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageView

import android.widget.Toast

import kotlinx.android.synthetic.main.activity_ingredients_detail.*
import com.squareup.picasso.Picasso
import com.google.firebase.database.DatabaseReference



class ingredientsDetail : AppCompatActivity() {
    lateinit var rootRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients_detail)
        val item_pic = findViewById<ImageView>(R.id.pic)


        val ingredientId = intent.extras.getString("selectedRecipe")
        val pictureId = intent.extras.getString("picture")
        val ingDets   =  intent.extras.getString("list")

        val someList : Array <String> = arrayOf(ingDets.trim())
        val downloadedUrl = pictureId

        recipe_name.text = ingredientId



        if (downloadedUrl.isEmpty()) {
            item_pic.setImageResource(R.mipmap.ic_placeholder_icon)
        } else {
            Picasso.get().load(downloadedUrl).resize(180, 120).into(item_pic)
        }

        for ( a in someList){

            ingredientsList.text = a.removeSurrounding("[]")
        }
        Toast.makeText(applicationContext, ingDets, Toast.LENGTH_LONG).show()



    }


}