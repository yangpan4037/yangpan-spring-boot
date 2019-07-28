package site.yangpan.rest.docs.controller;

import org.springframework.web.bind.annotation.*;
import site.yangpan.rest.docs.entity.UserEntity;

/**
 * UserController
 * Created by yangpan on 2019-07-28 21:19.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 查询
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    public UserEntity get(@PathVariable("userId") String userId){
        return new UserEntity(userId, "yangpan");
    }

    /**
     * 新增
     * @param userEntity
     * @return
     */
    @PutMapping("/insert")
    public UserEntity insert(@RequestBody UserEntity userEntity){
        return userEntity;
    }

    /**
     * 更新
     * @param userEntity
     * @return
     */
    @PostMapping("/update")
    public UserEntity update(@RequestBody UserEntity userEntity){
        return userEntity;
    }

    /**
     * 删除
     * @param userId
     * @return
     */
    @DeleteMapping("/{userId}")
    public boolean delete(@PathVariable("userId") String userId){
        return true;
    }

}
