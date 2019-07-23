package com.pcf.aopdemo

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class DatabindingActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewDataBinding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
        MyApp.init(this)
//        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(this)
        viewDataBinding.root.setOnClickListener {  }
    }

    @SingleClick
    override fun onClick(p0: View?) {
        Toast.makeText(this@DatabindingActivity, "我被点击了", Toast.LENGTH_SHORT).show()
    }
}