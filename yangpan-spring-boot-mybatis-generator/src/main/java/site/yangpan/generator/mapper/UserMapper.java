package site.yangpan.generator.mapper;

import site.yangpan.generator.entity.UserEntity;

public interface UserMapper {
    int deleteByPrimaryKey(String user_id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    UserEntity selectByPrimaryKey(String user_id);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}