package com.pcf.aopdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
