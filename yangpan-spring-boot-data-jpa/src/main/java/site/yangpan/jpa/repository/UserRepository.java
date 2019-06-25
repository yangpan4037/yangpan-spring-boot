package site.yangpan.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import site.yangpan.jpa.entity.UserEntity;

import java.util.List;

/**
 * 继承JpaRepository接口并且传入实体UserEntity和主键字段的类型
 *
 * 1.如果简单的查询可以根据“findBy字段名”进行查询
 * 2.如果需要自定SQL查询则需要通过@Query并且设置nativeQuery = true
 *
 * Created by yangpan on 2019-06-25 14:49.
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    List<UserEntity> findByName(String name);

    /**
     * 自定义sql查询
     * @return
     */
    @Query(value = "select * from t_user where name='yangpan'", nativeQuery = true)
    List<UserEntity> findByCustom();
}
