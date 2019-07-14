package site.yangpan.mapperhelper.mapper;

import site.yangpan.mapperhelper.entity.UserEntity;
import tk.mybatis.mapper.common.Mapper;

/**
 * 一旦继承了Mapper<T>,继承的Mapper就拥有了Mapper<T>所有的通用方法。
 * 注意: 如果是mysql数据库则还可以继承一个MySqlMapper<T>
 * Created by yangpan on 2019-07-14 14:15.
 */
public interface UserMapper extends Mapper<UserEntity> {
}