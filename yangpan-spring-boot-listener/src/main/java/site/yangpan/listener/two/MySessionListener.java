package site.yangpan.listener.two;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 实现监听器方式二
 * 1.通过注解@WebListener和实现一个监听器接口创建自定义监听器
 * 2.在启动类上添加包扫描@ServletComponentScan("site.yangpan.listener.two")
 * 说明：由于@WebListener是servlet注解，所以添加自定义包扫描
 * Created by yangpan on 2019-07-01 16:04.
 */
@WebListener
public class MySessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("自定义监听器实现HttpSessionListener可以监听HttpSession事件，HttpSession初始化。。sessionId：" + se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("自定义监听器实现HttpSessionListener可以监听HttpSession事件，HttpSession初始化。。sessionId：" + se.getSession().getId());
    }

}
