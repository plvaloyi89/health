package com.example.pvaloyi.healthart


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper




class databaseHelper (context: Context,
                      factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME,
        factory, DATABASE_VERSION) {


    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_PRODUCTS_TABLE = "CREATE TABLE " +
                TABLE_NAME + "("+ COLUMN_PIC + "TEXT,"+ COLUMN_PRODUCTNAME + "TEXT,"+ COLUMN_Desc + "TEXT,"+ COLUMN_Price +"TEXT)"
        db.execSQL(CREATE_PRODUCTS_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun add( product : orderCart ){
        val values = ContentValues()
        values.put(COLUMN_PIC, product.item_pic)
        values.put(COLUMN_PRODUCTNAME, product.itemName)
        values.put(COLUMN_Desc, product.itemDesc)
        values.put(COLUMN_Price, product.itemPrice)

        val db = this.writableDatabase

        db.insert(TABLE_NAME, null, values)
        db.close()

    }

//    fun findProduct(): shopStore? {
//        val query =
//            "SELECT * FROM $TABLE_PRODUCTS"
//
//        val db = this.readableDatabase
//
//        val cursor = db.rawQuery(query, null)
//
//        var product: shopStore? = null
//
//        if (cursor.moveToFirst()) {
//            cursor.moveToFirst()
//
//            val pic = cursor.getString(0)
//            val name = cursor.getString(1)
//            val description = cursor.getString(2)
//            val price = cursor.getString(3)
//            product = shopStore(pic, name, description,price)
//            cursor.close()
//        }
//
//        db.close()
//        return product
//    }


    companion object {

        val DATABASE_NAME ="Cart.db"
        val DATABASE_VERSION = 1
        val TABLE_NAME ="Orders"


        val COLUMN_PIC = "itemPic"
        val COLUMN_PRODUCTNAME = "productname"
        val COLUMN_Desc = "description"
        val COLUMN_Price = "price"



    }



}


