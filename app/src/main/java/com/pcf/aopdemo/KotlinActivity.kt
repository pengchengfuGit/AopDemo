package com.pcf.aopdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast

class KotlinActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApp.init(this)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(this)
    }

    @SingleClick
    override fun onClick(p0: View?) {
        Toast.makeText(this@KotlinActivity, "我被点击了", Toast.LENGTH_SHORT).show()
    }
}