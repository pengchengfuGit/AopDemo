package com.pcf.aopdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        MyApp.init(this);
        startToast();
//        methodTwo();
    }

    @NeedLogin(tipType = NeedLogin.SHOW_TOAST, loginActivity = MainActivity.class)
    public void startToast() {
        Toast.makeText(this, "执行VIP动作", Toast.LENGTH_SHORT).show();
//        val intent = Intent(context, SecondActivity::class.java)
//        context.startActivity(intent)
    }

//    @NeedLogin()
//    private void methodTwo(){
//        Toast.makeText(this, "执行VIP动作", Toast.LENGTH_SHORT).show();
//    }

    @SingleClick
    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "我被点击了", Toast.LENGTH_SHORT).show();
    }
}
