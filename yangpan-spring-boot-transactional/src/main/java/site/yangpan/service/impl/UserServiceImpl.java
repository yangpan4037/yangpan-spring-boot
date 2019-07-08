package site.yangpan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import site.yangpan.entity.UserEntity;
import site.yangpan.repository.UserRepository;
import site.yangpan.service.DeptService;
import site.yangpan.service.UserService;

/**
 * UserServiceImpl
 * Created by yangpan on 2019-07-08 22:06.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeptService deptService;

    /**
     * 测试事务的传播机制
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void propagation() {
        deptService.save();
        //int i = 1 / 0;
        UserEntity user = new UserEntity("yangpan","18");
        userRepository.save(user);
    }

    /**
     * 测试事务隔离级别
     */
    @Override
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void isolation() {

    }


    /**
     * 测试事务回滚
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rollback() {

    }



}
