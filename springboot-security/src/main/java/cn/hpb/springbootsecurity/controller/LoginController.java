package cn.hpb.springbootsecurity.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @Author hanpengbo
 * @Date 2020/1/16 17:01
 **/
@Controller
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    
    @RequestMapping("/role")
    @ResponseBody
    @PreAuthorize("hasRole('role02')")
    public String hashRole(){
        return "该用户拥有角色 role01";
    }
    
    @RequestMapping(value = "/hello")
    public ModelAndView hello()throws Exception{
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
            Collection<? extends GrantedAuthority> authorities = ((UserDetails) principal).getAuthorities();
            logger.info("roles:"+objectMapper.writeValueAsString(authorities));
        } else {
             username = principal.toString();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username1",username);
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
