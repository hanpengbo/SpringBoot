package cn.hpb.springbootsecurity.entity;

import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hanpengbo
 * @Date 2020/1/17 9:06
 **/
public class User implements UserDetails,Serializable {
    private Integer id;
    private String username;
    private String password;
    private List<Role> authorities;
    
    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }
    
    @Override
    public List<Role> getAuthorities() {
        return authorities;
    }
   
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
