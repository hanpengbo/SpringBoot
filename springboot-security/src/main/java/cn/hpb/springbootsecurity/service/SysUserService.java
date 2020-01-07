package cn.hpb.springbootsecurity.service;

import cn.hpb.springbootsecurity.dao.SysUserMapper;
import cn.hpb.springbootsecurity.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author hanpengbo
 * @Date 2020/1/7 14:45
 **/
@Service
public class SysUserService {
    @Autowired
    private SysUserMapper userMapper;
    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
