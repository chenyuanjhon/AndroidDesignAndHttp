OkHttp的作用：
    同异步get,post请求
    文件的上传下载
    加载图片(内部会图片大小自动压缩)
    支持请求回调，直接返回对象、对象集合
    支持session的保持

OkHttp的优点：

    支持HTTP/2，HTTP/2通过使用多路复用技术在一个单独的TCP连接上支持并发
    通过在一个连接上一次性发送多个请求或接收数据（如何使用？）

    支持GZIP，可以压缩下载体积（如何使用？）

    响应缓存可以避免重复请求，减少流量使用（响应缓存的机制？）

    会从很多常用的连接问题中自动恢复（哪些问题？）

    如果你的服务器配置了多个IP地址，当一个IP连接失败的时候，OkHttp会自动尝
    试连接下一个IP

    OkHttp还处理了代理服务器问题和SSL握手失败问题（代理服务器？
    怎么处理的？）

OKHttp的使用：
    同步异步：
        同步使用：execute()；异步使用：enqueue(CallBack callBack);
    get、post
        get:

        post:
            post 提交字符串(String)     new Request.Builder().post(RequestBody.create())
            post 提交流(Stream)        new Request.Builder().post(new RequestBody)
            post 提交文件(file)        new Request.Builder().post(RequestBody.create())
            post 提交表单(form)        new Request.Builder().post(new FormBody.Builder().build())它继承自RequestBody
            post 分块请求(form、file等) MultipartBody.Builder()

            提取响应头：response.header(Key);
            解析json： response.body().charStream()
            响应缓存： okHttpClient.setCache(file,cacheSize)
                缓存应当不能被其他程序读写
                一个缓存目录应当对应一个缓存访问
            Force a network response (强制从服务器抓取数据)：
                connection.addRequestProperty("Cache-Control", "no-cache");
            Force a cache response (优先使用缓存)
                connection.addRequestProperty("Cache-Control", "only-if-cached");
                InputStream cached = connection.getInputStream();

OkHttp的实现流程：
    整体流程：
    通过RealCall发送请求，发送的请求通过dispatcher来调度请求，并通过拦截器责任链来获取
    请求的结果（getResponseWithInterceptorChain()）,执行完时，通知dispatcher请求已经完
    成。流程图请看okHttp_full_process.png,来自于拆OKHttp。

    重连机制：
    主要类图：

OkHttp的设计模式思考：
    生成器模式：(builder模式)对象的构建与表示分离，同样的构建可以创建不同的表示。
        我的理解就是：可以创建不同配置的同一对象。
    责任链模式(Chain of responsibility)：使多个对象都有机会处理请求，从而避免请求的发送者
        和接收者之间的耦合，将这些对象连成一条链，并沿着这条链传递请求，直到有一个对象处理它
        为止。
    观察者模式：
    工厂模式：是什么工厂模式还不知道

OkHttp的封装：noHttp、Retrofit
