package cn.hpb.springbootsecurity.mapper;

import cn.hpb.springbootsecurity.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    
    @Select(" SELECT t1.* FROM role t1,user_role t2 WHERE t1.id = t2.role_id and t2.user_id = #{userId}")
    List<Role> getRolesByUserId(Integer userId);
}
