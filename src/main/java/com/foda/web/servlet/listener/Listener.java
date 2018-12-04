package com.foda.web.servlet.listener;

/**
 * @ author pxz
 * @ date 2018/12/4 0004-下午 2:23
 */
public interface Listener {
    /**
     * 一旦出现了某一种事假，达到了某一个状态，就调用这个方法
     */
    void print();
}
