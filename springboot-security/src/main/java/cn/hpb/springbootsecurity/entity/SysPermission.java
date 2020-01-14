package cn.hpb.springbootsecurity.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @Author hanpengbo
 * @Date 2020/1/10 16:00
 **/
@Data
public class SysPermission implements Serializable {
    static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String url;
    
    private Integer roleId;
    
    private String permission;
    
    private List permissions;
    
    public List getPermissions() {
        return Arrays.asList(this.permission.trim().split(","));
    }
}
