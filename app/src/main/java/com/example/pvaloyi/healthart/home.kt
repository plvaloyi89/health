package com.example.pvaloyi.healthart


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.*
import com.squareup.picasso.Picasso


class home : Fragment() {

    lateinit var ref : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_home, container, false)

        ref = FirebaseDatabase.getInstance().getReference("bio")



        val proPic = view.findViewById<ImageView>(R.id.imageView)
        val bio = view.findViewById<TextView>(R.id.aboutMe)


        ref.addValueEventListener(object : ValueEventListener {


            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context,"sorry", Toast.LENGTH_LONG ).show()


            }
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()){

                    for (e in p0.children){
                        val ing = e.getValue(homeOb::class.java)
                        bio.text = e.child("aboutMe").value.toString()

                        val downloadedUrl= e.child("profile_pic").value.toString()

                        if (downloadedUrl.isEmpty()) {
                            proPic.setImageResource(R.mipmap.ic_placeholder_icon);
                        } else{
                            Picasso.
                                get().
                                load(downloadedUrl).
                                resize(80,100).
                                into(proPic);
                        }
                    }


                }
            }

        })

        return view

    }

    companion object {
        fun newInstance(): home = home()
    }

}
