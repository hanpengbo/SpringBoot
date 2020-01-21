package cn.hpb.springbootsecurity.securingweb;

import cn.hpb.springbootsecurity.entity.Permission;
import cn.hpb.springbootsecurity.entity.User;
import cn.hpb.springbootsecurity.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 自定义权限验证
 * @Author hanpengbo
 * @Date 2020/1/21 9:58
 **/
    @Component
    public class CustomPermissionEvaluator implements PermissionEvaluator {
        @Autowired
        private PermissionMapper permissionMapper;
        @Override
        public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
            if (authentication == null || targetDomainObject == null || permission == null){
                return false;
            }
            User user = (User) authentication.getPrincipal();
            List<Permission> permissions = permissionMapper.queryPermissionByUserId(user.getId());
            if (!CollectionUtils.isEmpty(permissions)){
                for (Permission permission1 : permissions) {
                    if (permission1.getTarget().equals(targetDomainObject) && permission1.getPermission().equals(permission)){
                        return true;
                    }
                }
            }
            return false;
        }
        
        @Override
        public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
            return false;
        }
    }
