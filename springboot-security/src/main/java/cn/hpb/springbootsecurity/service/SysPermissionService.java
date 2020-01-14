package cn.hpb.springbootsecurity.service;

import cn.hpb.springbootsecurity.dao.SysPermissionMapper;
import cn.hpb.springbootsecurity.entity.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hanpengbo
 * @Date 2020/1/10 16:05
 **/
@Service
public class SysPermissionService {
    @Autowired
    private SysPermissionMapper permissionMapper;
    
    /**
     * 获取指定角色所有权限
     */
    public List<SysPermission> listByRoleId(Integer roleId) {
        return permissionMapper.listByRoleId(roleId);
    }
}
