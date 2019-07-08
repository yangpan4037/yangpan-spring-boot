package site.yangpan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.yangpan.entity.DeptEntity;

/**
 * DeptRepository
 * Created by yangpan on 2019-07-08 22:36.
 */
public interface DeptRepository extends JpaRepository<DeptEntity, String> {
}
