package com.example.pvaloyi.healthart

import android.media.Image
import android.provider.MediaStore
import java.net.URL

//  class  recipe {
//
//
//    var objectId: String? = null
//      var objImg : String?= null
//      var itemText: String?= null
//
//
//}

class recipe(val id: String,val item_pic: String , val itemName:String, val ingredients :List<String>
                ){
  constructor():this(
      "",
      "",
      "",
      listOf("")
  )
}