package site.yangpan.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import site.yangpan.entity.UserEntity;

import java.util.List;

/**
 * UserRepository
 * Created by yangpan on 2019-07-05 22:17.
 */
public interface UserRepository extends JpaRepository<UserEntity, String> {

    /**
     * @Cacheable 对有参数的方法进行缓存
     */
    @Cacheable(value = "findByName", key = "#name + ''", unless="#result == null")
    List<UserEntity> findByName(String name);


    /**
     * @Cacheable 对没有参数的方法进行缓存
     */
    @Cacheable("customUser")
    @Query(value = "select * from t_user where name='yangpan'", nativeQuery = true)
    List<UserEntity> findByCustom();


    /**
     * 对有指定形式的缓存进行移除
     */
    @CacheEvict(value = "findByName", key = "#name + ''")
    @Query(value = "select '移除了带有${name}的缓存！' from dual", nativeQuery = true)
    void removeByName(String name);


    /**
     * 对指定的缓存进行移除
     */
    @CacheEvict("customUser")
    @Query(value = "select '移除了缓存customUser！' from dual", nativeQuery = true)
    void removeByCustom();

}