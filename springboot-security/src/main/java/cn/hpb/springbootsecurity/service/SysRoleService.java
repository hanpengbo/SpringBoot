package cn.hpb.springbootsecurity.service;

import cn.hpb.springbootsecurity.dao.SysRoleMapper;
import cn.hpb.springbootsecurity.entity.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hanpengbo
 * @Date 2020/1/7 14:46
 **/
@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;
    
    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
}
