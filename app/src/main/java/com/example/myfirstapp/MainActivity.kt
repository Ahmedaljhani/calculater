package com.example.myfirstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import com.example.myfirstapp.databinding.ActivityMainBinding
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class MainActivity : AppCompatActivity() {
    var num1:String =""
    var mark=" "
    var num2:String = ""
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")

        private lateinit var binding:ActivityMainBinding
        @SuppressLint("SetTextI18n")
        @RequiresApi(Build.VERSION_CODES.O)
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            //fun to check the state of dark mode
            setDarkMode()
            setFontColor()
            setFontSize()
            //create buttons
            binding.apply {
                btnSitteng.setOnClickListener {
                    val intent = Intent(this@MainActivity,SecondActivity::class.java)
                    startActivity(intent)
                }
                //numbers buttons
                btn0.setOnClickListener{addNUmber(0,mark)}
                btn1.setOnClickListener{addNUmber(1,mark)}
                btn2.setOnClickListener{addNUmber(2,mark)}
                btn3.setOnClickListener{addNUmber(3,mark)}
                btn4.setOnClickListener{addNUmber(4,mark)}
                btn5.setOnClickListener{addNUmber(5,mark)}
                btn6.setOnClickListener{addNUmber(6,mark)}
                btn7.setOnClickListener{addNUmber(7,mark)}
                btn8.setOnClickListener{addNUmber(8,mark)}
                btn9.setOnClickListener{addNUmber(9,mark)}
                //operations buttons
                btnpls.setOnClickListener { addoperation("+")  }
                btnmul.setOnClickListener { addoperation("x")  }
                btnsub.setOnClickListener { addoperation("-")  }
                btnrem.setOnClickListener { addoperation("%")  }
                btndiv.setOnClickListener { addoperation("/")  }
                btnqu.setOnClickListener {
                    if (num1!=""&&num2=="") {
                        num1+="."
                        tvSecNumber.text=num1
                    }
                    else if(num1 != ""&& num2!= ""){
                        num2+="."
                        tvFirstNumber.text=num2
                    }
                }
                btnequl.setOnClickListener {
                    when(mark){
                        "+" ->tvResults.setText((num1.toDouble()+num2.toDouble()).toString())
                        "-" ->tvResults.setText((num1.toDouble()-num2.toDouble()).toString())
                        "x" ->tvResults.setText((num1.toDouble()*num2.toDouble()).toString())
                        "/" ->tvResults.setText((num1.toDouble()/num2.toDouble()).toString())
                        "%" ->tvResults.setText((num1.toDouble()%num2.toDouble()).toString()) }
                                          }
                btnmarket.setOnClickListener {
                    if (num1.isNotEmpty()&&num2==""){
                        num1=(num1.toInt()* -1).toString()
                        tvFirstNumber.text= num1} else
                        if (num1.isNotEmpty()&&num2.isNotEmpty()){
                            num2= (num2.toInt()* -1).toString()
                            tvSecNumber.text=num2}
                }
                btncos.setOnClickListener {
                    if (num1!=""&&num2==""){
                        tvFirstNumber.text="cos($num1)"
                        num1= cos(num1.toFloat()).toString()
                        tvResults.setText(num1)}
                    if (num1!=""&&num2!=""){
                        tvSecNumber.text="cos($num2)"
                        num2= cos(num2.toFloat()).toString()
                        tvResults.setText(num2)}
                }
                btnsin.setOnClickListener {
                    if (num1!=""&&num2==""){
                        tvFirstNumber.text="sin($num1)"
                        num1= sin(num1.toFloat()).toString()
                        tvResults.setText(num1)}
                    if (num1!=""&&num2!=""){
                        tvSecNumber.text="sin($num2)"
                        num2= sin(num2.toFloat()).toString()
                        tvResults.setText(num2)}
                }
                btntan.setOnClickListener {
                    if (num1!=""&&num2==""){
                        tvFirstNumber.text="tan($num1)"
                        num1= tan(num1.toFloat()).toString()
                        tvResults.setText(num1)}
                    if (num1!=""&&num2!=""){
                        tvSecNumber.text="tan($num2)"
                        num2= tan(num2.toFloat()).toString()
                        tvResults.setText(num2)}
                }
                btnac.setOnClickListener {
                    num1=""
                    num2=""
                    mark =" "
                    tvSecNumber.text=" "
                    tvFirstNumber.text=" "
                    tvOperations.text=" "
                    tvResults.setText("0")
                }
             btndel.setOnClickListener {
                 if (num1!=""&&num2==""){
                     var tex1=tvFirstNumber.text.toString()
                     if (tex1.isNotEmpty()){tvFirstNumber.text=tex1.dropLast(1)}
                     num1=tvFirstNumber.text.toString()
                 }else if (num1!=""&&num2!=""){
                     var tex2=tvSecNumber.text.toString()
                     if (tex2.isNotEmpty()){tvSecNumber.text=tex2.dropLast(1)}
                     num2=tvSecNumber.text.toString()
                 }
                 if (num2.isEmpty()){
                     var texop=tvOperations.text.toString()
                     if (texop.isNotEmpty()){tvOperations.text=texop.drop(1)}
                     mark=tvOperations.text.toString()
                 }
                 if (num1.isEmpty()) tvResults.setText("0")
             }
            }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addNUmber(value:Int, opration:String){
        if( opration == " ") {
            num1 += value.toString()
            binding.tvFirstNumber.text=num1
        }
        else if (opration.isNotEmpty()){
            num2 += value.toString()
            binding.tvSecNumber.text = num2
        }else {  num1 += value.toString()
            binding.tvFirstNumber.text=num1}
        }
    @RequiresApi(Build.VERSION_CODES.O)
    fun addoperation(op:String){
        mark=op
        binding.tvOperations.text=op
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setFontSize()
        setDarkMode()
        setFontColor()
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private  fun setFontSize(){
        val sharedpref =MySharedSitting(this@MainActivity)
        binding.tvResults.textSize = sharedpref.getFontSize()
        binding.tvFirstNumber.textSize = sharedpref.getFontSize()
        binding.tvSecNumber.textSize = sharedpref.getFontSize()
    }
    private fun setDarkMode() {
        val sharedpref =MySharedSitting(this@MainActivity)
        var mode = sharedpref.getMode()

    when (mode ) {
         true ->   {AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            Toast.makeText(this@MainActivity,"The dark mode turn on the font is ${sharedpref.getFontSize()}",Toast.LENGTH_SHORT).show()}
          false -> {AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
              Toast.makeText(this@MainActivity,"The dark mode turn off the font is ${sharedpref.getFontSize()}",Toast.LENGTH_SHORT).show()}
    }}
    @RequiresApi(Build.VERSION_CODES.O)
    private  fun setFontColor(){
        val sharedpref =MySharedSitting(this@MainActivity)
        var color= sharedpref.getFontColor()
        when(color){
            1 ->{binding.tvResults.setTextColor(Color.parseColor("#FFAE2828"))
                binding.tvFirstNumber.setTextColor(Color.parseColor("#FFAE2828"))
                binding.tvSecNumber.setTextColor(Color.parseColor("#FFAE2828")) }
            2 ->{binding.tvResults.setTextColor(Color.parseColor("#0aad3f"))
                binding.tvFirstNumber.setTextColor(Color.parseColor("#0aad3f"))
                binding.tvSecNumber.setTextColor(Color.parseColor("#0aad3f")) }
            3 ->{binding.tvResults.setTextColor(Color.parseColor("#FFFFFFFF"))
                binding.tvFirstNumber.setTextColor(Color.parseColor("#FFFFFFFF"))
                binding.tvSecNumber.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
        }
    }
    }




