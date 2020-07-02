package com.example.pvaloyi.healthart

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.database.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import android.database.sqlite.SQLiteDatabase






class MainActivity : AppCompatActivity() {


   lateinit var ref : DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val actionBar = supportActionBar
        actionBar!!.setDisplayShowHomeEnabled(true)
        actionBar.setIcon(R.drawable.ic_home_black_44dp)






//        toolbar.setDisplayShowHomeEnabled(true)
//        toolbar.setIcon(R.drawable.ic_home_black_24dp)



        ref = FirebaseDatabase.getInstance().getReference("bio")



        val proPic = findViewById<ImageView>(R.id.imageView)
        val bio = findViewById<TextView>(R.id.aboutMe)


        ref.addValueEventListener(object : ValueEventListener {


            override fun onCancelled(p0: DatabaseError) {
                //Toast.makeText(context,"sorry", Toast.LENGTH_LONG ).show()


            }
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()){

                    for (e in p0.children){
                     //   val ing = e.getValue(homeOb::class.java)
                        bio.text = e.child("aboutMe").value.toString()

                        val downloadedUrl= e.child("profile_pic").value.toString()

                        if (downloadedUrl.isEmpty()) {
                            proPic.setImageResource(R.mipmap.ic_placeholder_icon)
                        } else{
                            Picasso.
                                get().
                                load(downloadedUrl).
                                resize(80,100).
                                into(proPic)
                        }
                    }


                }
            }

        })





    }


    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val  homeFrag = home.newInstance()
                openFragment(homeFrag)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shop -> {
//                message.setText("Shop")
                val  shopFragment = Shop.newInstance()
                openFragment(shopFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_book_online -> {
//
                val  bookOnline = bookOnline.newInstance()
                openFragment(bookOnline)
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_health_history -> {
                val  healthFrag = health.newInstance()
                openFragment(healthFrag)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_recipes -> {
                val  recipesFrag = recipes.newInstance()
                openFragment(recipesFrag)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }





}
