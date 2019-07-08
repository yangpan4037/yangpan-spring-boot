package site.yangpan.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * DeptEntity
 * Created by yangpan on 2019-07-08 22:33.
 */
@Entity
@Table(name = "t_dept")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class DeptEntity implements Serializable {

    private static final long serialVersionUID = 596114988814437453L;

    @Id
    @GeneratedValue(generator = "jpa-uuid")
    private String id;

    @Column
    private String name;

    public DeptEntity(String name) {
        this.name = name;
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
}

