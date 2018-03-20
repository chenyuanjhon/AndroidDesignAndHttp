package com.cy.androidarchitecturedesign.mvvmwithbind;

import android.util.Log;
import android.view.View;

/**
 * Created by Mb on 2017/11/10.
 * 事件的实现
 */

public class EventListenerImpl implements EventListener {

    @Override
    public void click1(View v) {
        Log.i("aaa", "嘿嘿嘿");
    }

    @Override
    public void click2(View v) {
        Log.i("aaa", "哈哈哈");
        Student student = new Student("李四", "北京");
        Log.i("aaa", "新哈哈哈"+student.getName()+student.getAddr());
        student.setName("王五");
        student.setAddr("南京");
        Log.i("aaa", "新二哈哈哈"+student.getName()+student.getAddr());
    }
}
