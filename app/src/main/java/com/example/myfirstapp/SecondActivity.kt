package com.example.myfirstapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
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
        var btnColorRed=findViewById<RadioButton>(R.id.radioButton)
        var btnColorWhite=findViewById<RadioButton>(R.id.radioButton2)
        var btnColorBlack=findViewById<RadioButton>(R.id.radioButton3)
        val pref = MySharedSitting(this)
        when(pref.getFontColor()){
            1 -> btnColorRed.isChecked=true
            2 -> btnColorWhite.isChecked=true
            2 -> btnColorBlack.isChecked=true
        }
        btnmode.isChecked=pref.getMode()
        fontext.setText(pref.getFontSize().toString())

        btnsave.setOnClickListener {
            var intent=Intent(this@SecondActivity,MainActivity::class.java)
            pref.saveFontSize(fontext.text.toString().toFloat())
            if (btnmode.isChecked){
                pref.setMode(btnmode.isChecked)
            }else{
                pref.setMode(false)
            }
            if (btnColorRed.isChecked) pref.seveFontColor(1) else
                if (btnColorWhite.isChecked) pref.seveFontColor(2) else
                    if (btnColorBlack.isChecked) pref.seveFontColor(3)

            Toast.makeText(this , "the Setting is saved ",Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

    }
}