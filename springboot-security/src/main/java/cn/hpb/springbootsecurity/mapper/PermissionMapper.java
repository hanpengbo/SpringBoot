package cn.hpb.springbootsecurity.mapper;

import cn.hpb.springbootsecurity.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author hanpengbo
 * @Date 2020/1/21 10:43
 **/
@Mapper
public interface PermissionMapper {
    
    @Select("SELECT t5.* from `user` t1 INNER JOIN user_role t2 " +
                    " ON t1.id = t2.user_id INNER JOIN role t3 on " +
                    " t2.role_id = t3.id INNER JOIN role_permission t4 ON " +
                    " t4.role_id = t3.id INNER JOIN permission t5 on " +
                    " t5.id = t4.permission_id WHERE t1.id = #{userId}")
    List<Permission> queryPermissionByUserId(Integer userId);
}
