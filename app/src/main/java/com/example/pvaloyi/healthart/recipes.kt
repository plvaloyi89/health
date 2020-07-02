package com.example.pvaloyi.healthart


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.DatabaseReference
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener


class recipes : Fragment() {

    lateinit var ref : DatabaseReference
    lateinit var ListOfRecipes:MutableList<recipe>
    lateinit var listview:ListView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_recipes, container, false)

        ListOfRecipes = mutableListOf()
        listview = view.findViewById(R.id.recipes_recipesList)
        ref = FirebaseDatabase.getInstance().getReference("recipe")

        ref.addValueEventListener(object :ValueEventListener{


            override fun onCancelled(p0: DatabaseError) {
                Toast.makeText(context,"sorry", Toast.LENGTH_LONG ).show()


            }
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()){
                    ListOfRecipes.clear()
                    for (e in p0.children){
                        val ing = e.getValue(recipe::class.java)
                        ListOfRecipes.add(ing!!)
                    }

                    val adapter = recipeAdapter(context,R.layout.row_items,ListOfRecipes)
                    listview.adapter = adapter



                    listview.setOnItemClickListener({ adapterView, view, position, id ->


                        val altref = adapter.getItem(position)


                        val intent = Intent(context, ingredientsDetail::class.java)
                        intent.putExtra("selectedRecipe" , altref.itemName)
                        intent.putExtra("picture", altref.item_pic)
                        intent.putExtra("list", altref.ingredients.toString())
                        startActivity(intent)


                    })


                }
            }

        })




        return view
    }

    companion object {
        fun newInstance(): recipes = recipes()
    }



}




