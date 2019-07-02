package site.yangpan.listener.two;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 测试session监听器的controller
 * Created by yangpan on 2019-07-01 16:26.
 */
@RestController
public class CreateSessionController {

    @RequestMapping("/createSession")
    public String test(HttpServletRequest request){
        //创建session的
        HttpSession session=request.getSession();
        session.setAttribute("username","yangpan");
        session.setAttribute("password","123456");
        System.out.println(session.getId());
        return "session 创建成功。。";
    }
}
