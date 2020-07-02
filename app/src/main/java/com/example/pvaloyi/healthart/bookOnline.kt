package com.example.pvaloyi.healthart


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView

import android.widget.Toast
import android.content.Intent

class bookOnline : Fragment() {





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_book_online, container, false)

        val appointment : CalendarView = view.findViewById(R.id.book_selectDate)



        appointment.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Note that months are indexed from 0. So, 0 means January, 1 means february, 2 means march etc.
            val msg = " " + dayOfMonth + "/" + (month + 1) + "/" + year
            val bookDay = Intent(context, confirmDayDialog ::class.java)
            bookDay.putExtra("day", msg)
            startActivity(bookDay)

            //Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()


        }


        return view
    }

    companion object {
        fun newInstance(): bookOnline = bookOnline()
    }

}
