package cn.hpb.springbootsecurity.entity;

import java.io.Serializable;

/**
 * @Author hanpengbo
 * @Date 2020/1/7 14:40
 **/
public class SysRole implements Serializable {
    static final long serialVersionUID = 1L;
    
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
}
