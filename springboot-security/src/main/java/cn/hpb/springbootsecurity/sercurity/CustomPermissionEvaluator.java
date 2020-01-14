package cn.hpb.springbootsecurity.sercurity;

import cn.hpb.springbootsecurity.entity.SysPermission;
import cn.hpb.springbootsecurity.service.SysPermissionService;
import cn.hpb.springbootsecurity.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Author hanpengbo
 * @Date 2020/1/10 16:08
 **/
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private SysPermissionService permissionService;
    @Autowired
    private SysRoleService roleService;
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        User user = (User)authentication.getPrincipal();
        Collection<GrantedAuthority> authorities = user.getAuthorities();
        for(GrantedAuthority authority : authorities) {
            String roleName = authority.getAuthority();
            Integer roleId = roleService.selectByName(roleName).getId();
            List<SysPermission> permissionList = permissionService.listByRoleId(roleId);
            for(SysPermission sysPermission : permissionList) {
                List permissions = sysPermission.getPermissions();
                if(targetUrl.equals(sysPermission.getUrl())
                           && permissions.contains(targetPermission)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }

}
