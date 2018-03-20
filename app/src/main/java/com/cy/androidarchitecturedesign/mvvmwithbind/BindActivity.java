package com.cy.androidarchitecturedesign.mvvmwithbind;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cy.androidarchitecturedesign.R;
import com.cy.androidarchitecturedesign.databinding.ActivityBindBinding;


/**
 *
 */
public class BindActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBindBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_bind);
        final Student student = new Student("张三", "上海");
        //方法一：
        binding.setStu(student);
        //方法二：
//        binding.setVariable(BR.stu,student);
//        Log.i("aaa",student.getName());

        binding.vt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("aaa",student.getName());
                student.setName("王五");

            }
        });

//        binding.setEvent(new EventListenerImpl());
    }
}
