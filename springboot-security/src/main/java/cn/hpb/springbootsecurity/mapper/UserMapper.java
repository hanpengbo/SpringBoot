package cn.hpb.springbootsecurity.mapper;

import cn.hpb.springbootsecurity.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Author hanpengbo
 * @Date 2020/1/17 9:12
 **/
@Mapper
public interface UserMapper {
    
    @Select("select * from user where username = #{username} ")
    User getUserByUsername(String username);
}
