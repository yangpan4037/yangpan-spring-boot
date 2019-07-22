package site.yangpan.apidoc.controller;

import org.springframework.web.bind.annotation.*;
import site.yangpan.apidoc.entity.UserEntity;

/**
 * 测试 apidoc Controller
 * Created by yangpan on 2019-07-22 21:52.
 */
@RestController
@RequestMapping("/user")
public class ApiDocController {

    /**
     * @api {get} /user/:id 请求用户信息
     * @apiName GetUser
     * @apiGroup User
     *
     * @apiParam {Number} id 用户ID
     *
     * @apiSuccess {String} firstname 姓
     * @apiSuccess {String} lastname  名
     *
     * @apiSuccessExample 成功响应:
     *     HTTP/1.1 200 OK
     *     {
     *       "firstname": "John",
     *       "lastname": "Doe"
     *     }
     *
     * @apiError UserNotFound 找不到用户ID.
     *
     * @apiErrorExample 错误响应:
     *     HTTP/1.1 404 Not Found
     *     {
     *       "error": "UserNotFound"
     *     }
     */
    @PutMapping
    public UserEntity select(@RequestBody UserEntity userEntity){
        return new UserEntity("1", "yangpan", "18");
    }

    /**
     * @api {put} /user/ 修改用户信息
     * @apiName PutUser
     * @apiGroup User
     *
     * @apiParam {Number} id          用户ID
     * @apiParam {String} [firstname] 姓名
     * @apiParam {String} [lastname]  名
     *
     * @apiSuccessExample 成功响应:
     *     HTTP/1.1 200 OK
     */
    @PostMapping
    public UserEntity update(@RequestBody UserEntity userEntity){
        return new UserEntity("2", "yangpan", "18");
    }

}
