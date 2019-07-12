package site.yangpan.pagehelper.controller;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.yangpan.pagehelper.entity.UserEntity;
import site.yangpan.pagehelper.mapper.UserMapper;

import java.util.List;

/**
 * UserController
 * Created by yangpan on 2019-07-12 22:39.
 */
@RestController
@RequestMapping("/user/page")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 第一种分页方式:
     * 使用PageHelper.startPage(1, 10)方法后的第一个Mybatis的查询（Select）方法会被分页
     * @return
     */
    @GetMapping("/one")
    public PageInfo one(){
        PageHelper.startPage(1, 2);
        List<UserEntity> list = userMapper.findAll();
        PageInfo<UserEntity> data = new PageInfo<>(list);
        return data;
    }

    /**
     * 第二种分页方式:
     * 使用PageHelper.offsetPage(1, 10)
     * @return
     */
    @GetMapping("/two")
    public PageInfo two(){
        PageHelper.offsetPage(1, 2);
        List<UserEntity> list = userMapper.findAll();
        PageInfo<UserEntity> data = new PageInfo<>(list);
        return data;
    }

    /**
     * 第三种分页方式: jdk6,7用法
     * @return
     */
    @GetMapping("/three")
    public PageInfo three(){
        PageInfo<UserEntity> data = PageHelper.startPage(1, 2).doSelectPageInfo(new ISelect() {
            @Override
            public void doSelect() {
                userMapper.findAll();
            }
        });
        return data;
    }

    /**
     * 第四种分页方式: jdk8
     * @return
     */
    @GetMapping("/four")
    public PageInfo four(){
        PageInfo<Object> data = PageHelper.startPage(1, 2).doSelectPageInfo(() -> userMapper.findAll());
        return data;
    }


    /**
     * 特殊情况查询count
     * @return
     */
    @GetMapping("/count/one")
    public long count1(){
        long count = PageHelper.count(new ISelect() {
            @Override
            public void doSelect() {
                userMapper.findAll();
            }
        });
        return count;
    }


    /**
     * 特殊情况查询count
     * @return
     */
    @GetMapping("/count/two")
    public long count2(){
        long count = PageHelper.count(() -> userMapper.findAll());
        return count;
    }


}
