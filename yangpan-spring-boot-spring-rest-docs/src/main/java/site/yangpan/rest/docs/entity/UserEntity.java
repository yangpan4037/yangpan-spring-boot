package site.yangpan.rest.docs.entity;

/**
 * UserEntity
 * Created by yangpan on 2019-07-28 21:20.
 */
public class UserEntity {

    private String userId;

    private String userName;

    public UserEntity(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
