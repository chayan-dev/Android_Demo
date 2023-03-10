package com.shelfwatch_cam

import android.content.Intent
import android.widget.Toast
import com.facebook.react.bridge.*

class CameraModule(reactContext: ReactApplicationContext): ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String = "CameraModule"

  private val context = reactApplicationContext
//  private val reactContext = ReactContext()

  @ReactMethod
  fun createToastAnd(str:String){
    Toast.makeText(context,"data got from android : $str", Toast.LENGTH_LONG).show()
  }

  @ReactMethod
  fun openCamera(){
    val intent = Intent(context,CameraActivity::class.java)
    if(intent.resolveActivity(context.packageManager) != null){
      intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
      context.startActivity(intent)
    }
  }

}