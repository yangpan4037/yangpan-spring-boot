package site.yangpan.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.yangpan.jpa.entity.UserEntity;
import site.yangpan.jpa.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * UserController
 * Created by yangpan on 2019-06-25 14:52.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 新增
     * @param userEntity
     * @return
     */
    @PutMapping
    public UserEntity insert(@RequestBody UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    /**
     * 修改
     * @param userEntity
     * @return
     */
    @PostMapping
    public UserEntity update(@RequestBody UserEntity userEntity){
        return userRepository.save(userEntity);
    }

    /**
     * 删除
     * @param userEntity
     * @return
     */
    @DeleteMapping
    public void delete(@RequestBody UserEntity userEntity){
        userRepository.delete(userEntity);
    }

    /**
     * 查询一个
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public UserEntity select(@PathVariable("id") String id){
        Optional<UserEntity> optional = userRepository.findById(id);
        return optional.get();
    }

    /**
     * 查询全部
     * @return
     */
    @GetMapping("/list")
    public List<UserEntity> selectAll(){
        return userRepository.findAll();
    }

    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    @GetMapping("/name/{name}")
    public List<UserEntity> name(@PathVariable("name") String name){
        return userRepository.findByName(name);
    }

    /**
     * 自定义查询
     * @return
     */
    @GetMapping("/custom")
    public List<UserEntity> selectname(){
        return userRepository.findByCustom();
    }

}
