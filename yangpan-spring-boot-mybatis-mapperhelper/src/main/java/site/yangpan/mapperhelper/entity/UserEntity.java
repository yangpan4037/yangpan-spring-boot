package site.yangpan.mapperhelper.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 注解@Table(name = "t_user")不是必需的，如果不添加则实体名和表名一致
 */
@Table(name = "t_user")
public class UserEntity {

    @Id//注解@Id必须添加，否则selectByPrimaryKey不知道主键是哪个字段
    private String userId;

    @Column(name = "username")//注解@Column不是必需的，当数据库与实体字段不一致时使用
    private String username;

    private Date createTime;

    private Date updateTime;

    @Transient//注解@Transient可以忽略字段,添加该注解的字段不会作为表字段使用.
    private String yangpan;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getYangpan() {
        return yangpan;
    }

    public void setYangpan(String yangpan) {
        this.yangpan = yangpan;
    }
}