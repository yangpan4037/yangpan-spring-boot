package site.yangpan.redis.entity;

import java.io.Serializable;

/**
 * User
 * Created by yangpan on 2019-07-14 17:58.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 6569093199515425528L;

    private String id;

    private String name;

    private String password;

    public User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
