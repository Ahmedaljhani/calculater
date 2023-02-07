package com.example.myfirstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class MainActivity : AppCompatActivity() {
    var num1:String =""
    var mark=" "
    var num2:String = ""
    lateinit var text1:TextView
    lateinit var text2:TextView

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setDarkMode()

        val str : String = " "
        text1 = findViewById<TextView>(R.id.textViewinput1)
        text2 = findViewById<TextView>(R.id.textViewreinput2)
        val res1 = findViewById<TextView>(R.id.textViewresult)
        val btnstt = findViewById<ImageButton>(R.id.imageButton)
        val totalResult = findViewById<TextView>(R.id.totalresult)
        val pref = MySharedSitting(this)

        btnstt.setOnClickListener {
            val intent = Intent(this@MainActivity,SecondActivity::class.java)
            startActivity(intent)
        }
        var fontsize =pref.getFontSize()
        totalResult.setTextSize(fontsize)



        val btn0: Button = findViewById(R.id.btn0)
        btn0.setOnClickListener {

            addNUmber(0,mark)
        }
        val btn1: Button = findViewById(R.id.btn1)
        btn1.setOnClickListener {
            addNUmber(1,mark)
        }
        val btn2: Button = findViewById(R.id.btn2)
        btn2.setOnClickListener {
            addNUmber(2,mark)
        }
        val btn3: Button = findViewById(R.id.btn3)
        btn3.setOnClickListener {
            addNUmber(3,mark)
        }
        val btn4: Button = findViewById(R.id.btn4)
        btn4.setOnClickListener {
            addNUmber(4,mark)
        }
        val btn5: Button = findViewById(R.id.btn5)
        btn5.setOnClickListener {
            addNUmber(5,mark)
        }
        val btn6: Button = findViewById(R.id.btn6)
        btn6.setOnClickListener {
            addNUmber(6,mark)
        }
        val btn7: Button = findViewById(R.id.btn7)
        btn7.setOnClickListener {
            addNUmber(7,mark)
        }
        val btn8: Button = findViewById(R.id.btn8)
        btn8.setOnClickListener {
            addNUmber(8,mark)
        }
        val btn9: Button = findViewById(R.id.btn9)
        btn9.setOnClickListener {
            addNUmber(9,mark)
        }

        val btnpls: Button = findViewById(R.id.btnpls)
        btnpls.setOnClickListener {
            mark = "+"
            res1.text = mark.toString()
        }
        val btnmul: Button = findViewById(R.id.btnmul)
        btnmul.setOnClickListener {
            mark = "x"
            res1.text = mark.toString()
        }
        val btnsub: Button = findViewById(R.id.btnsub)
        btnsub.setOnClickListener {
            mark = "-"
            res1.text = mark.toString()
        }
        val btnrem: Button = findViewById(R.id.btnrem)
        btnrem.setOnClickListener {
            mark = "%"
            res1.text = mark.toString()
        }
        val btndiv: Button = findViewById(R.id.btndiv)
        btndiv.setOnClickListener {
            mark = "/"
            res1.text = mark.toString()
        }
        val btnqu: Button = findViewById(R.id.btnqu)
        btnqu.setOnClickListener {
            if (num1!=""&&num2=="") {
                num1+="."
                text1.text=num1
            }
            else if(num1 != ""&& num2!= ""){
                num2+="."
                text2.text=num2
            }
        }
        val btnequl: Button = findViewById(R.id.btnequl)
        btnequl.setOnClickListener {
            if (mark == "+")
                totalResult.text = (num1.toDouble()+num2.toDouble()).toString()

            if (mark == "-")
                totalResult.text = (num1.toDouble()-num2.toDouble()).toString()

            if (mark == "x")
                totalResult.text = (num1.toDouble()*num2.toDouble()).toString()
            if (mark == "/")
                totalResult.text = (num1.toDouble()/num2.toDouble()).toString()
            if (mark =="%")
                totalResult.text = (num1.toDouble()%num2.toDouble()).toString()

        }

        val btnsig :Button = findViewById(R.id.btnmarket)
        btnsig.setOnClickListener {
            if (num1==""&&num2==""){
                num1= "-${num1}"
            text1.text= num1} else
                if (num1!=""&&num2==""){
                num2= "-${num2}"
            text2.text=num2}
        }
        val btncos :Button = findViewById(R.id.btncos)
        btncos.setOnClickListener {
            if (num1!=""&&num2==""){
                text1.text="cos($num1)"
                num1= cos(num1.toFloat()).toString()
                totalResult.text=num1}
            if (num1!=""&&num2!=""){
                text2.text="cos($num2)"
                num2= cos(num2.toFloat()).toString()
                totalResult.text=num2}
        }
        val btnsin :Button = findViewById(R.id.btnsin)
        btnsin.setOnClickListener {
            if (num1!=""&&num2==""){
                text1.text="sin($num1)"
                num1= sin(num1.toFloat()).toString()
                totalResult.text=num1}
            if (num1!=""&&num2!=""){
                text2.text="sin($num2)"
                num2= sin(num2.toFloat()).toString()
                totalResult.text=num2}
        }
        val btntan :Button = findViewById(R.id.btntan)
        btntan.setOnClickListener {
            if (num1!=""&&num2==""){
                text1.text="tan($num1)"
                num1= tan(num1.toFloat()).toString()
                totalResult.text=num1}
            if (num1!=""&&num2!=""){
                text2.text="tan($num2)"
                num2= tan(num2.toFloat()).toString()
                totalResult.text=num2}
        }
        val btnAc :Button = findViewById(R.id.btnac)
        btnAc.setOnClickListener {
            num1=""
            num2=""
            mark =" "
            text1.text=" "
            text2.text=" "
            res1.text=" "
            totalResult.text="0"
        }
        val btndel :Button = findViewById(R.id.btndel)
        btndel.setOnClickListener {
            if (num1!=""&&num2==""){
                var tex1=text1.text.toString()
               if (tex1.isNotEmpty()){text1.text=tex1.dropLast(1)}
                num1=text1.text.toString()
            }else if (num1!=""&&num2!=""){
                var tex2=text2.text.toString()
                if (tex2.isNotEmpty()){text2.text=tex2.dropLast(1)}
                    num2=text2.text.toString()
            }
            if (num2.isEmpty()){
                var texop=res1.text.toString()
                if (texop.isNotEmpty()){res1.text=texop.drop(1)}
                mark=res1.text.toString()
            }
            if (num1.isEmpty()) totalResult.text="0"
        }
    }

    fun addNUmber(value:Int,opration:String){
        if( opration == " ") {
            num1 += value.toString()
            text1.text=num1
        }
        else if (opration.isNotEmpty()){
            num2 += value.toString()
            text2.text = num2
        }else {  num1 += value.toString()
            text1.text=num1}
        }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val sharedpref =MySharedSitting(this@MainActivity)
        val totalResult = findViewById<TextView>(R.id.totalresult)
        totalResult.setTextSize(sharedpref.getFontSize())
        setDarkMode()


    }

    private fun setDarkMode() {
        val sharedpref =MySharedSitting(this@MainActivity)
        var mode = sharedpref.getMode()

    when (mode ) {
         true ->   {AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Toast.makeText(this@MainActivity,"The dark mode turn on the font is",Toast.LENGTH_SHORT).show()}
          false -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    }


