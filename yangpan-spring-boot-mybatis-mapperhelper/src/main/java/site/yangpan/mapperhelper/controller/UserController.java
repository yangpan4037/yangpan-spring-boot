package site.yangpan.mapperhelper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.yangpan.mapperhelper.entity.UserEntity;
import site.yangpan.mapperhelper.mapper.UserMapper;

/**
 * UserController
 * Created by yangpan on 2019-07-14 12:00.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 查询一个
     * @return
     */
    @GetMapping("/{userId}")
    public UserEntity findByUserId(@PathVariable("userId") String userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 新增
     * @param user
     * @return
     */
    @PutMapping("/insert")
    public String insert(@RequestBody UserEntity user){
        userMapper.insert(user);
        return "新增成功！";
    }

    /**
     * 更新
     * @param user
     * @return
     */
    @PostMapping("/update")
    public String update(@RequestBody UserEntity user){
        userMapper.updateByPrimaryKey(user);
        return "更新成功！";
    }

    /**
     * 删除
     * @param userId
     * @return
     */
    @DeleteMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") String userId){
        userMapper.deleteByPrimaryKey(userId);
        return "删除成功！";
    }

}
