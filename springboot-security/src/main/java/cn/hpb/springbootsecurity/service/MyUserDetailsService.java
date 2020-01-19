package cn.hpb.springbootsecurity.service;

import cn.hpb.springbootsecurity.entity.User;
import cn.hpb.springbootsecurity.mapper.RoleMapper;
import cn.hpb.springbootsecurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author hanpengbo
 * @Date 2020/1/17 9:19
 **/
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.getUserByUsername(username);
        if (user != null){
            user.setAuthorities(roleMapper.getRolesByUserId(user.getId()));
        }
        return user;
    }
}
