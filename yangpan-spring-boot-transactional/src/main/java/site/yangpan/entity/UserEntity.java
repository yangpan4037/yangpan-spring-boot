package site.yangpan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * UserEntity
 * Created by yangpan on 2019-07-08 22:03.
 */
@Entity
@Table(name = "t_user")
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

    public UserEntity(String name, String age) {
        this.name = name;
        this.age = age;
    }

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
}
