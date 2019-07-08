package site.yangpan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.yangpan.entity.UserEntity;

/**
 * 描述
 * Created by yangpan on 2019-07-08 22:05.
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
