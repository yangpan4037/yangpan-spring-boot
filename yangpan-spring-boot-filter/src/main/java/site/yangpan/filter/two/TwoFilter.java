package site.yangpan.filter.two;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 通过@WebFilter注解，并且实现Filter接口
 * 注意@WebFilter这个注解是Servlet3.0的规范，并不是Spring boot提供的，所以我们还需要在启动类上添加@ServletComponetScan，指定扫描的包。
 * Created by yangpan on 2019-06-30 22:09.
 */
@WebFilter(urlPatterns = "/twoFilter", filterName = "twoFilter")
public class TwoFilter implements Filter {

    /**
     * 初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("twoFilter初始化中。。。");
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
        System.out.println("twoFilter开始进行过滤处理。。。");
        //调用该方法后，表示过滤器经过原来的url请求处理方法
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 销毁方法
     */
    @Override
    public void destroy() {
        System.out.println("twoFilter销毁中。。。");
    }
}
