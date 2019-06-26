package org.yangpan.bean;

/**
 * MyBean
 * Created by yangpan on 2019-06-26 16:27.
 */
public class MyBean {

    public MyBean() {
        System.out.println("这是一个不在springboot扫描范围内的类，使用XML配置Bean。。");
    }

    public String hello() {
        return "使用XML配置的Bean可以不在springboot扫描范围内的。。";
    }

}
