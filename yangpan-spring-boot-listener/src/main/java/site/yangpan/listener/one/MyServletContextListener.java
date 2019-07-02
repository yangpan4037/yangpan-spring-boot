package site.yangpan.listener.one;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 实现监听器方式一
 * 1.通过实现一个监听器接口创建自定义的监听器
 * 2.通过ServletListenerRegistrationBean将自定义监听器注册为spring管理的Bean
 * Created by yangpan on 2019-07-01 15:20.
 */
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("自定义监听器实现ServletContextListener可以监听ServletContext事件，ServletContext初始化。。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("自定义监听器实现ServletContextListener可以监听ServletContext事件，ServletContext销毁。。");
    }
}
