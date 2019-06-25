package site.yangpan.jpa.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 1.主键自动生成uuid
 *  在实体类上加上 @GenericGenerator(name = "jpa-uuid", strategy = "uuid")，
 *  在字段上加上 @GeneratedValue(generator = "jpa-uuid")
 *
 * 2.自动创建时间或更新时间
 *  在启动类上添加 @EnableJpaAuditing
 *  在实体类上加 @EntityListeners(AuditingEntityListener.class)
 *  在字段上加 @CreatedDate 或者 @LastModifiedDate
 *
 * Created by yangpan on 2019-06-25 14:29.
 */
@Entity
@Table(name = "t_user")
@EntityListeners(AuditingEntityListener.class)
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 596114988814437453L;

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Column
    private String name;

    @Column
    private String age;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    @CreatedDate
    private Date createTime;

    @Column
    @LastModifiedDate
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
