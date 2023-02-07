package com.example.myfirstapp

import android.content.Context

class MySharedSitting(context: Context) {
    companion object{
        private const val FILE_NAME ="user_sitting"
        private const val FONT="font"
        private const val MODE="mode"

    }
    private val sharedSitt=context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    fun saveFontSize(name :Float){
        sharedSitt.edit()
            .putFloat(FONT, name)
            .apply()
    }
    fun getFontSize(): Float {
        return sharedSitt.getFloat(FONT, 20f)
    }
    fun  setMode (mode:Boolean) {
          sharedSitt.edit()
            .putBoolean(MODE,mode)
            .apply()
    }
    fun getMode ():Boolean{
        return sharedSitt.getBoolean(MODE,false)
    }

}