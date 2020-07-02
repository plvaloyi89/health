package com.example.pvaloyi.healthart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

class homeAdapter(context: Context?, val layoutId:Int, val personObj:List<homeOb>)
    : ArrayAdapter<homeOb>(context,layoutId,personObj){



    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(layoutId, null)

        val proPic = view.findViewById<ImageView>(R.id.imageView)
        val bio = view.findViewById<TextView>(R.id.aboutMe)
        val person = personObj[position]

        val downloadedUrl= person.profile_pic

        if (downloadedUrl.isEmpty()) {
            // Rimage.setImageResource(R.mipmap.ic_placeholder_icon);
        } else{
            Picasso.
                get().
                load(downloadedUrl).
                resize(80,80).
                into(proPic)
        }

        bio.text = person.aboutMe

        return view

    }


}