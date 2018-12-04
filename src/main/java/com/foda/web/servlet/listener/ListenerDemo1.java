package com.foda.web.servlet.listener;

/**
 * 接口回调
 *
 * 监听器：监听一个事件的发生，状态的改变
 * 监听器的内部机制：
 *      接口回调:实现给接口，然后回调实现了该接口的类的方法
 * @ author pxz
 * @ date 2018/12/4 0004-下午 2:07
 */
public class ListenerDemo1 {
    /**
     * JavaSE，可以直接传被回调类的实例或者直接new 一个对象出来，调用被回调类的方法
     * 现在，为了规范，定义了一种接口，只要实现了该接口，然后定义该接口的类型就可以了
     *
     */
    public void print(Listener listener){
        for(int i=0;i<10;i++){
            System.out.println("循环到了5");
            if(i == 5){
                System.out.println("回调被回调类的方法");
                listener.print();
            }
        }
    }
}
class CallListener implements Listener{

    public void print() {
        System.out.println("实现了接口的方法print()");
    }
}
class TestListener{
    public static void main(String[] args) {
        ListenerDemo1 demo1 = new ListenerDemo1();
        demo1.print(new CallListener());
    }
}
