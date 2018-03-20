package com.cy.androidarchitecturedesign.mvvmwithbind;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.cy.androidarchitecturedesign.BR;

/**
 * Created by Mb on 2017/11/9.
 * bean
 */

public class Student extends BaseObservable{
    private String name;
    private String addr;

    public Student() {
    }

    public Student(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
        notifyPropertyChanged(BR.addr);
    }
}
