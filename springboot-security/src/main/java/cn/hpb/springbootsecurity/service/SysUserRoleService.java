package cn.hpb.springbootsecurity.service;

import cn.hpb.springbootsecurity.dao.SysUserRoleMapper;
import cn.hpb.springbootsecurity.entity.SysRole;
import cn.hpb.springbootsecurity.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author hanpengbo
 * @Date 2020/1/7 14:46
 **/
@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;
    
    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
    
    public List<SysRole> roleListByUserId(Integer userId){
        return userRoleMapper.roleListByUserId(userId);
    }
}
