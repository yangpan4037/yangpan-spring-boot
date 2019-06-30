package site.yangpan.filter.one;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器第一种实现方法：实现Filter接口，然后通过FilterRegistrationBean注册成Bean
 * Created by yangpan on 2019-06-30 21:57.
 */
public class FirstFilter implements Filter {

    /**
     * 初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("firstFilter初始化中。。。");
    }

    /**
     * 过滤方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("firstFilter开始进行过滤处理。。。");
        //调用该方法后，表示过滤器经过原来的url请求处理方法
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy() {
        System.out.println("firstFilter销毁中。。。");
    }

}
