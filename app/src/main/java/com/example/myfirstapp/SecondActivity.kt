package com.example.myfirstapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged


class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    companion object;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var fontext=findViewById<EditText>(R.id.editTextNumber)
        var btnsave =findViewById<Button>(R.id.btnsave)
        var btnmode =findViewById<Switch>(R.id.switch1)
        val pref = MySharedSitting(this)


        btnmode.isChecked=pref.getMode()
        fontext.setText(pref.getFontSize().toString())
        var modeswitch= btnmode.setOnCheckedChangeListener { _, isChecked ->return@setOnCheckedChangeListener }

        btnsave.setOnClickListener {
            var intent=Intent(this@SecondActivity,MainActivity::class.java)


            pref.saveFontSize(fontext.text.toString().toFloat())

            if (btnmode.isChecked){
                pref.setMode(btnmode.isChecked)
            }else{
                pref.setMode(false)
            }


            Toast.makeText(this , "the Sitting is saved  ${pref.getFontSize()} ",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}