package site.yangpan.swagger2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * UserEntity
 * Created by yangpan on 2019-07-14 20:32.
 */
@ApiModel(value = "用户对象", description = "包含用户信息的对象")
public class UserEntity {

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "地址")
    private String address;

    public UserEntity(String userId, String username, String email, String address) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
