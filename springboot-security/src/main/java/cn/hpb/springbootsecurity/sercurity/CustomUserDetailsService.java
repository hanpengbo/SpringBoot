package cn.hpb.springbootsecurity.sercurity;

import cn.hpb.springbootsecurity.entity.SysRole;
import cn.hpb.springbootsecurity.entity.SysUser;
import cn.hpb.springbootsecurity.entity.SysUserRole;
import cn.hpb.springbootsecurity.service.SysRoleService;
import cn.hpb.springbootsecurity.service.SysUserRoleService;
import cn.hpb.springbootsecurity.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author hanpengbo
 * @Date 2020/1/7 16:08
 **/
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private SysUserService userService;
    @Autowired
    private SysUserRoleService userRoleService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SysUser user = userService.selectByName(username);
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限
        List<SysRole> userRoles = userRoleService.roleListByUserId(user.getId());
        for (SysRole userRole : userRoles) {
            ((ArrayList<GrantedAuthority>) authorities).add(new SimpleGrantedAuthority(userRole.getName()));
        }
        // 返回UserDetails实现类
        return new User(user.getName(), user.getPassword(), authorities);
    }
}
