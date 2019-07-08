package site.yangpan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.service.UserService;

/**
 * UserController
 * Created by yangpan on 2019-07-08 22:06.
 */
@RestController
@RequestMapping("/transactional")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 测试事务的传播机制
     * @return
     */
    @GetMapping("/propagation")
    public String propagation(){
        userService.propagation();
        return "操作成功！";
    }


    /**
     * 测试事务隔离级别
     * @return
     */
    @GetMapping("/isolation")
    public String isolation(){
        userService.isolation();
        return "操作成功！";
    }

}
