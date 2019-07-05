package site.yangpan.service;

import site.yangpan.entity.UserEntity;

import java.util.List;

/**
 * UserService 接口
 * Created by yangpan on 2019-07-05 22:20.
 */
public interface UserService {

    List<UserEntity> findByName(String name);

    List<UserEntity> findByCustom();

    void removeByName(String name);

    void removeByCustom();
}
