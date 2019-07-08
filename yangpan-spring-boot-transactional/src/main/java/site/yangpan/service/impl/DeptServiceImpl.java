package site.yangpan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import site.yangpan.entity.DeptEntity;
import site.yangpan.repository.DeptRepository;
import site.yangpan.service.DeptService;

/**
 * DeptServiceImpl
 * Created by yangpan on 2019-07-08 22:37.
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save() {
        DeptEntity dept = new DeptEntity("销售部");
        // int i = 1 / 0;
        deptRepository.save(dept);
    }
}
