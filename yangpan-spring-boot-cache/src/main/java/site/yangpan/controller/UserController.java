package site.yangpan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.entity.UserEntity;
import site.yangpan.service.UserService;

import java.util.List;

/**
 * UserController
 * Created by yangpan on 2019-07-05 22:27.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findByName/{name}")
    public List<UserEntity> findByName(@PathVariable("name") String name){
        return userService.findByName(name);
    }

    @GetMapping("findByCustom")
    public List<UserEntity> findByCustom(){
        return userService.findByCustom();
    }

    @GetMapping("removeByName/{name}")
    public String removeByName(@PathVariable("name") String name){
        userService.removeByName(name);
        return "移除了根据" + name + "查询的缓存！";
    }

    @GetMapping("removeByCustom")
    public String removeByCustom(){
        userService.removeByCustom();
        return "移除了缓存customUser！";
    }
}
