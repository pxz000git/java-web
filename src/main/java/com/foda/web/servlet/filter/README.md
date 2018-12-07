## Filter
## 过滤器：其实就是对客户端发出来的请求进行过滤，浏览器发出，
## 然后服务器通过servlet处理。在中间就可以进行过滤，其实过滤器
## 就是起到了拦截的作用。
## 作用
    1、对一些敏感词汇进行过滤
    2、设置统一的编码
    3、自动登录
## 使用
    1、定义类，实现Filter接口，在web.xml注册过滤器
## Filter生命周期
    创建：服务器启动
    调用：...
    销毁：服务器关闭
## Filter执行顺序
    1、请求-->过滤器-->如果过滤器放行，才能到servlet
    2、如果有多个过滤器，那么他们会按照注册的映射(mapping)来排队，
    只要中间有一个过滤器不放行，那么后面排队的过滤器以及servlet都不会接收到请求
## init()方法，FilterConfig可以获取，可以获取filter在注册时的名字，类似servlet
## 放行，那么doFilter里面的方法操作，使用filterChain
## 拦截：
    1、<url-partten>/*</url-partten>写法格式和servlet一样
        1. 全路径匹配  以 /  开始 
                /LoginServlet
        2. 以目录匹配 以 / 开始  以 * 结束
            /demo01/*  
        3. 以后缀名匹配  以 * 开始 以后缀名结束
            *.jsp  *.html *.do 
    2、针对dispatcher设置
        REQUEST:只要是请求，都拦截，默认就是REQUEST
        RORWARD:只要是转发，都拦截
        ERROR:页面出错发生跳转，拦截
        INCLUDE:包含页面的时候就拦截
  
    