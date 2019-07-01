package site.yangpan.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器，实现HandlerInterceptor接口
 * Created by yangpan on 2019-07-01 11:17.
 */
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 拦截器拦截处理之前
     * 如果返回false,就不会执行拦截处理postHandle
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器拦截处理之前。。preHandle");
        return true;
    }

    /**
     * 拦截器拦截处理操作
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器拦截处理操作。。postHandle");
    }

    /**
     * 拦截器拦截处理之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器拦截处理之后。。afterCompletion");
    }
}
