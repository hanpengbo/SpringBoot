package cn.hpb.springbootsecurity.dao;

import cn.hpb.springbootsecurity.entity.SysRole;
import cn.hpb.springbootsecurity.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;


@Mapper
public interface SysUserRoleMapper {
    @Select("SELECT * FROM sys_user_role WHERE user_id = #{userId}")
    List<SysUserRole> listByUserId(Integer userId);
    
    @Select("SELECT t2.* FROM sys_user_role t1,sys_role t2 WHERE t1.role_id = t2.id and t1.user_id = #{userId}")
    List<SysRole> roleListByUserId(Integer userId);
}
