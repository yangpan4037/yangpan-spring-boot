package site.yangpan.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import site.yangpan.swagger2.entity.UserEntity;

/**
 * UserController
 * Created by yangpan on 2019-07-14 20:33.
 */
@RestController
@RequestMapping("/user")
@Api("用户信息相关接口")
public class UserController {

    @ApiOperation(value="获取用户详细信息", notes="根据userId获取用户详情")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String")
    @GetMapping("/{userId}")
    public UserEntity get(@PathVariable("userId") String userId){
        return new UserEntity("3eb5bde7","yangpan", "916780135@11.com","四川成都");
    }

    @ApiOperation(value="保存用户详细信息", notes="根据User对象保存用户信息")
    @PutMapping("/save")
    public String put(@RequestBody UserEntity userEntity){
        return "保存成功！";
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @PostMapping("/update")
    public String post(@RequestBody UserEntity userEntity){
        return "更新成功！";
    }

    @ApiOperation(value="删除用户详细信息", notes="根据userId来指定删除用户详细信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String")
    @DeleteMapping("/delete/{userId}")
    public String delete(@PathVariable("userId") String userId){
        return "删除成功！";
    }
}
