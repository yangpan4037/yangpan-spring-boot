package site.yangpan.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import site.yangpan.mybatis.entity.UserEntity;

import java.util.List;

/**
 * 如果启动类添加了@MapperScan(...)，那么就不需要加@Mapper注解，反之亦然
 * Created by yangpan on 2019-07-11 22:01.
 */
@Mapper
public interface UserMapper {

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    @Select("select * from t_user where user_id=#{userId}")
    UserEntity findByUserId(String userId);

    /**
     * 新增
     * @param userEntity
     * @return
     */
    @Insert("insert into t_user(user_id, username, create_time, update_time) values(REPLACE(UUID(),'-',''), #{username}, now(), now())")
    void insert(UserEntity userEntity);

    /**
     * 更新
     * @param userEntity
     * @return
     */
    @Update("update t_user set username=#{username}, update_time=now() where user_id=#{userId}")
    void update(UserEntity userEntity);

    /**
     * 删除
     * @param userId
     * @return
     */
    @Delete("delete from t_user where user_id = #{userId}")
    void delete(String userId);

    /**
     * 查询全部
     * @return
     * @param userEntity
     */
    List<UserEntity> findAll(UserEntity userEntity);
}
