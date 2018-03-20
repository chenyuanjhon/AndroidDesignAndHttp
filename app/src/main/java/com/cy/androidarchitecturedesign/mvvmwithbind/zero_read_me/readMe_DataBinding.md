Data Binding:
    2015年的Google IO大会上，Android 团队发布了一个数据绑定框架（Data
    Binding Library）

作用：
    单纯的摆脱findViewById
    绑定基本数据类型及String
    绑定Model数据
    绑定事件
    通过静态方法转换数据类型
    通过运算符操作数据
    自定义Binding的类名
    绑定相同Model的操作
    model变量改变自动更新数据
    绑定List/Map等集合数据
    Observable自动更新
    DataBinding与include标签的结合
    DataBinding与RecyclerView的结合

官方教程：
    https://developer.android.com/tools/data-binding/guide.html

配置：
    在gradle中添加
    android {
        ...
        dataBinding{
            enabled=true;
        }
        ...
    }

使用：
    1：xml中绑定数据介绍
        1：布局基本格式
            <?xml version="1.0" encoding="utf-8"?>
             <!--layout作为根布局-->
            <layout xmlns:android="http://schemas.android.com/apk/res/android"
                    xmlns:app="http://schemas.android.com/apk/res-auto"
                    xmlns:tools="http://schemas.android.com/tools">
                     <!--data是与布局绑定的数据，name是变量名，type是变量类型，可以是
                     基本类型，也可以是自定义的类型。还有另外一种形式：使用import导入包
                     -->
                <data>
                    <variable
                        name="这个是变量名比如为(name1)"
                        type="这个是变量类型比如为(String)"/>
                </data>
            <!--下面是正常的布局就好了-->

            </layout>
        2：数据绑定格式
            1:正向绑定
            数据绑定通过@{name}来绑定，{name}中的name指的是variable变量中的name1
            同时也可以支持运算符运算和静态方法调用和转换。
            2:双向绑定
            数据绑定通过@={name}来绑定，对就是加个 =
        3：绑定不同的数据类型
            1：绑定基本数据类型及String
                <variable
                            name="content"
                            type="String" />

                <variable
                            name="enabled"
                            type="boolean" />
            2：绑定Model（bean）
                形式一：
                     <!--指定类型的全称-->
                     <variable
                         name="stu"
                         type="com.cy.androidarchitecturedesign.mvvmwithbind.Student"/>
                形式二：
                    <import type="com.cy.androidarchitecturedesign.mvvmwithbind.Student"/>
                    <variable
                        name="stu"
                        type="Student"/>
                在Java中设置数据也有两种形式,伪代码如下
                形式一：
                    binding.setStu(new Student())
                形式二：
                    binding.setVariable(BR.stu,new Student())
            3:绑定事件
                1.android:onClick="@{event.click1}"
                2.android:onClick="@{event::click2}"
                3.android:onClick="@{()->event.click3(title4)}"
                [注]：()->event.click3(title4)是lambda表达式写法，
                也可以写成：(view)->event.click3(title4),前面(view)表示onClick方法的传递的参数，
                如果event.click3()方法中不需要用到view参数，可以将view省略。

                事件绑定原理解析：
                当然event.click1也可以写成(view)->event.click1(view)，将onClick(View view)的
                view参数传递给event.click1(view)方法。
                大概就这意思，以下是伪代码:
                onclick(View view){
                    event.click1(view)
                }
            4：调用静态方法
                <!--调用静态方法，需要先导入需要的包    当然java中的lang包可以不用导包-->
                <import type="com.cy.Utils" />
                <!--就和java中写代码一样，只要符合数据类型就好-->
                android:text="@{Utils.getName(user)}"
            5：运算符操作数据

            6：自定义Binding的类名

            7：绑定相同model的操作
                第一种，同一个类的2个对象，只需对象名不同就可以
                    <import type="com.cy.databinding.User" />

                            <variable
                            name="user3"
                            type="User" />

                            <variable
                            name="user4"
                            type="User" />
                第二种不同的2个类，对象名相同
                    <import type="com.cy.databinding.User" />

                            <variable
                                name="user4"
                                type="User" />

                    <!--因为type="User"都为User类，会导致不知道到那个包，
                    所以可以通过alias属性重命名type的类型，但实际上alias被
                    指定的那个类型(如：com.cy.databinding.model.User)-->
                            <import type="com.cy.databinding.model.User" alias="Model"/>
                            <variable
                                name="user5"
                                type="Model"  />

            8：model数据改变时自动更新数据
                步骤一：让model继承BaseObservable，对属性的get方法添加@Bindable，eg:
                    @Bindable
                    public String getName() {
                        return name;
                    }
                    对属性的set方法添加：notifyPropertyChanged(BR.name);eg:
                    public void setName(String name) {
                            this.name = name;
                            notifyPropertyChanged(BR.name);
                        }
                步骤二：调用同一对象的变量的引用，比如本例为student，使用setName设置新名字，便会更新布局。

                注意:必须为同一对象的引用！！！

                实现原理：
                Model类继承BaseObservable,BaseObservable实现android.databinding.Observable接口，
                Observable接口可以允许附加一个监听器到model对象以便监听对象上的所有属性的变化。notifyChange()
                通知更新所有参数，可以不用和@Bindable注解配合使用

实现原理：





需要注意的问题：
    1:很多人说 ActivityBindBinding binding = DataBindingUtil.setCo-
    ntentView(this, R.layout.activity_bind);会自动生成ActivityBindBinding
    这个类，但是在我用的时候并没有自己生成，然而我的配置都是正确，不知道为什么，
    需要我手动打出来。
    2：包名改变的时候，在xml中需View绑定的bean并没有跟随着改变，需要手动一个
    一个的重新改过来。


参考：
http://blog.csdn.net/qq_33689414/article/details/52205703
http://connorlin.github.io/2016/07/13/Android-Data-Binding-%E7%B3%BB%E5%88%97-%E4%BA%8C-Binding%E4%B8%8EObserver%E5%AE%9E%E7%8E%B0%E5%8E%9F%E7%90%86/