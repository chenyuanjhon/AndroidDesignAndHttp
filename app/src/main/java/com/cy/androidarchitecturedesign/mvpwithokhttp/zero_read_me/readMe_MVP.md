MVP概述：
MVP分为三层：Model、View、Presenter

Model与MVC的model是一样，activity与fragment不再作为controller层
而是纯粹的View层，用户的所有交互事件都通过presenter层处理，从而实现
了model与View的完全解耦。View层和presenter层的通信是通过接口进行的
，View层实现接口，在presenter中调用接口中的方法。

最好的方法是使用fragment作为View层，activity用于创建View和presen-
ter的控制器？？？？？

对于View的接口，去观察功能上的操作，然后考虑(模拟登陆)：
该操作需要什么？（getUserName, getPassword，clearNameAndPassword）
该操作的结果，对应的反馈？(toMainActivity, showFailedError)
该操作过程中对应的友好的交互？(showLoading, hideLoading)

对于presenter主要看该功能有什么操作(模拟登陆)：
login和clear

MVP关系图：请查看MVP_relationship.png