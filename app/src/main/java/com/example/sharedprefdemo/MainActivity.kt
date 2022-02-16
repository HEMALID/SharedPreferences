package com.example.sharedprefdemo

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var et=findViewById<EditText>(R.id.edValue)
        val sp: SharedPreferences =this.getSharedPreferences("data", Context.MODE_APPEND)
        var bs=findViewById<Button>(R.id.btnSave)
        var bv=findViewById<Button>(R.id.btnView)
        var bl=findViewById<Button>(R.id.btnClear)

        bs.setOnClickListener {
            var ed:SharedPreferences.Editor=sp.edit()
            ed.putString("text",et.text.toString() )
            ed.apply()
            ed.commit()
            Toast.makeText(applicationContext,"Saved...",Toast.LENGTH_LONG).show()
            et.text.clear()
        }
        bv.setOnClickListener {
            var x=sp.getString("text","Value is not Available!!")
            Toast.makeText(applicationContext,x,Toast.LENGTH_LONG).show()
        }
        bl.setOnClickListener {
            var ed=sp.edit()
            ed.clear()
            ed.apply()
            Toast.makeText(applicationContext, "Data Cleared", Toast.LENGTH_SHORT).show()
        }
    }
}