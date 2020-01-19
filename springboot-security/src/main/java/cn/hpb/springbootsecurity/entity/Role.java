package cn.hpb.springbootsecurity.entity;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * @Author hanpengbo
 * @Date 2020/1/17 9:10
 **/
public class Role implements Serializable, GrantedAuthority {
    private Integer id;
    private String name;
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getAuthority() {
        return name;
    }
}
