package site.yangpan.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 * 可以通过@ControllerAdvice 或者 @RestControllerAdvice注解进行全局异常处理
 * Created by yangpan on 2019-06-23 21:03.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 返回JSON
     * 这里你可以通过@ExceptionHandler注解指定处理异常类型（可以自定义异常进行特殊处理）并且可以通过@ResponseBody返回json格式的信息
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Map<String, Object> returnJson(HttpServletRequest request, Exception e){
        e.printStackTrace();
        Map<String, Object> result = new HashMap();
        result.put("success", false);
        result.put("message", "系统出现异常" + e.getMessage());
        return result;
    }


    /**
     * 服务端错误页面
     * 我们还可以返回ModelAndView跳转到服务端异常页面
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public ModelAndView jumpPage(HttpServletRequest request, Exception e){
        e.printStackTrace();
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }


    /**
     * 如果是异步请求返回JSON,否则服务器错误页面
     * @param request
     * @param e
     * @return
     */
//    @ExceptionHandler(Exception.class)
//    @ResponseBody
//    public Object errorHandler(HttpServletRequest request, Exception e){
//        e.printStackTrace();
//        String header = request.getHeader("x-requested-with");
//        if(header != null && header.equals("XMLHttpRequest")){
//            return "这里返回JSON";
//        }else{
//            ModelAndView modelAndView = new ModelAndView("error");
//            return modelAndView;
//        }
//    }
}
