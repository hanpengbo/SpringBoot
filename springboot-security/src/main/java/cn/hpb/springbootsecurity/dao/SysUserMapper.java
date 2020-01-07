package cn.hpb.springbootsecurity.dao;

import cn.hpb.springbootsecurity.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface SysUserMapper {
    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    SysUser selectByName(String name);
}
