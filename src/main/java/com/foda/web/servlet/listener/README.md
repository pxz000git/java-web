##web监听器
###总共有8个，划分为三种类型
###监听三个作用域的创建和销毁
### request-->HttpServletRequest
### session---HttpSession
### application-->ServletContext
### ServletContextListener
### ServletRequestListener:
### HttpSessionListener:访问jsp(会)，访问servlet(调用getSession(),会)
## (一)使用监听器
       定义一个类，实现接口，
       注册 配置监听器(在web.xml中)
## 作用：
        ServletContextListener：
            利用他来在servletContext创建的时候加载资源或引擎
            执行任务调度，执行某一个任务
        HttpSessionListener：
            统计在线人数
## (二)可以监听在作用域中值 添加|替换|移除等动作
        session-->HttpSessionAttributeListener
        request-->ServletRequestAttributeListener
        servletContext-->ServletContextAttributeListener
## (三)监听httpSession里面存值的状态的变更，这类监听器不用注册
       1、HttpSessionBindingListener
            让JavaBean实现给接口，监听对象和session绑定和解除绑定的动作
       2、HttpSessionAttributeListener
            可以用于监听session的值是钝化(序列化)还是活化(反序列化)的动作
            (序列化)：把内存的数据存储到硬盘上
            (反序列化)：把硬盘上的数据读到内存中
       session中的值钝化、活化的意义：
            session中的值可能会很多，并且我们有很长一段时间不会使用这个内存中的值，
            那么可以考虑把session中的值可以存储到硬盘上(钝化),
            等下次使用的时候，再从硬盘上提取出来(活化)
       如何让session中的值在一定时间内钝化：
            配置：1、在tomcat服务器中conf文件中的context.xml里面配置
                       对所有的运行在这个服务器的项目生效  
                 2、在tomcat中的conf/Catalina/localhost/context.xml中配置
                       对 localhost域名生效。  localhost:8080
                 3、在自己的web工程中的MEAT-INF/context.xml中配置
                        只对当前的工程生效。
                配置内容：
                maxIdleSwap ： 1分钟不用就钝化
                directory ：  钝化后的那个文件存放的目录位置。 
                <Context>
                    <Manager className="org.apache.catalina.session.PersistentManager" maxIdleSwap="1">
                        <Store className="org.apache.catalina.session.FileStore" directory="itheima"/>
                    </Manager>
                </Context>