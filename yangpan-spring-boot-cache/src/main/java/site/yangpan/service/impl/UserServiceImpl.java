package site.yangpan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.yangpan.entity.UserEntity;
import site.yangpan.repository.UserRepository;
import site.yangpan.service.UserService;
import java.util.List;

/**
 * UserService 实现类
 * Created by yangpan on 2019-07-05 22:21.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<UserEntity> findByCustom() {
        return userRepository.findByCustom();
    }

    @Override
    public void removeByName(String name) {
        userRepository.removeByName(name);
    }

    @Override
    public void removeByCustom() {
        userRepository.removeByCustom();
    }
}
