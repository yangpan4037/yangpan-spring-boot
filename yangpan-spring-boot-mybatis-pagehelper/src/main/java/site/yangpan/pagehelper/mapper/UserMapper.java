package site.yangpan.pagehelper.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import site.yangpan.pagehelper.entity.UserEntity;

import java.util.List;

/**
 * UserMapper
 * Created by yangpan on 2019-07-12 22:37.
 */
@Mapper
public interface UserMapper {

    @Select("select * from t_user")
    List<UserEntity> findAll();
}
