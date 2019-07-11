package site.yangpan.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.yangpan.mybatis.entity.UserEntity;
import site.yangpan.mybatis.mapper.UserMapper;

import java.util.List;

/**
 * UserController
 * Created by yangpan on 2019-07-11 22:00.
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
        return userMapper.findByUserId(userId);
    }

    /**
     * 新增
     * @param userEntity
     * @return
     */
    @PutMapping("/insert")
    public String insert(@RequestBody UserEntity userEntity){
        userMapper.insert(userEntity);
        return "新增成功！";
    }

    /**
     * 更新
     * @param userEntity
     * @return
     */
    @PostMapping("/update")
    public String update(@RequestBody UserEntity userEntity){
        userMapper.update(userEntity);
        return "更新成功！";
    }

    /**
     * 删除
     * @param userId
     * @return
     */
    @DeleteMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") String userId){
        userMapper.delete(userId);
        return "删除成功！";
    }

    /**
     * 根据条件查询列表
     * @return
     */
    @PostMapping("/list")
    public List<UserEntity> list(@RequestBody UserEntity userEntity){
        return userMapper.findAll(userEntity);
    }

}
