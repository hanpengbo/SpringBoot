package cn.hpb.springbootsecurity.entity;

import java.io.Serializable;

/**
 * @Author hanpengbo
 * @Date 2020/1/7 14:42
 **/
public class SysUserRole implements Serializable {
    static final long serialVersionUID = 1L;
    
    private Integer userId;
    
    private Integer roleId;
    
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public Integer getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
