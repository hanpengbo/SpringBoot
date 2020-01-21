package cn.hpb.springbootsecurity.entity;

import java.io.Serializable;

/**
 * @Author hanpengbo
 * @Date 2020/1/21 10:39
 **/
public class Permission implements Serializable {
    private int id;
    
    private String permission;
    
    private String name;
    
    private String target;
    
    public String getTarget() {
        return target;
    }
    
    public void setTarget(String target) {
        this.target = target;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getPermission() {
        return permission;
    }
    
    public void setPermission(String permission) {
        this.permission = permission;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
