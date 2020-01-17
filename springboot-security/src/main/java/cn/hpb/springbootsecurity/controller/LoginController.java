package cn.hpb.springbootsecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author hanpengbo
 * @Date 2020/1/16 17:01
 **/
@Controller
public class LoginController {
    @RequestMapping(value = "/hello")
    public ModelAndView hello(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = null;
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
             username = principal.toString();
        }
        System.out.println(username);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username1",username);
        modelAndView.setViewName("hello");
        return modelAndView;
    }
}
