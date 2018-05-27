package com.hciot.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hciot.demo.entity.User;
import com.hciot.demo.service.impl.UserServiceImpl;
@Controller
public class LoginController {
	@Autowired
    private UserServiceImpl userServiceImpl;
	//________________作 业 5 用户登录验证实验______________________________________________
	    @RequestMapping(value="/login",method = RequestMethod.GET)
	    @ResponseBody
	    public String login1(String name,String password) throws Exception {
	    	
	    	System.out.println(name);
	    	System.out.println(password);

	    	User user = new User();
	    	
	    	System.out.println("login被调用");
	    	user=userServiceImpl.getUserByName(name);
	    	if (user!=null) {
				if(user.getPassword().equals(password) ) {
					System.out.println("ok");
					return "<html><body>\r\n" + 			
					"<h1 style=\"color:green;\">登录验证成功<h1>\r\n" + 
					"</body></html>";			
				}
				else {
					System.out.println("error");
					return "<html><body>\r\n" + 				
					"<h1 style=\"color:red;\">密码错误!<h1>\r\n" + 
					"</body></html>";
				}
			}
	    	else {
	    		System.out.println("用户名不存在");
	    		return "<html><body>\r\n" + 	
				"<h1 >用户名不存在<h1>\r\n" + 
				"</body></html>";
	    	}
	    	
	    }
	    //________________作业6:修改密码
	    @RequestMapping(value="/newpassword",method = RequestMethod.GET)
        @ResponseBody
        public String newpassword(String name,String oldpassword,String newpassword) throws Exception {
                
                System.out.println(name);
                System.out.println(oldpassword);
                
                User user = new User();
                
                System.out.println("newpassword被调用");
                user=userServiceImpl.getUserByName(name);
                if (user!=null&&oldpassword!=null) {
                            if(user.getPassword().equals(oldpassword)&&newpassword!=null) {
                                       user.setPassword(newpassword);
                                            if (userServiceImpl.updateByPrimary(user)>0) {
                                                    System.out.println("ok");
                                                    return "密码修改ok";
                                            }
                                            else {
                                                    return "更新失败";
                                            }                                                                                                                                
                            }
                            else if(newpassword==null) {
                            	return "新密码不能为空";
                            }
                            else {
                                    System.out.println("error");
                                    return "旧密码错误";
                            }
                    }
                else if(user==null) {
                	return "用户名不能为空";
                }
                else if(oldpassword==null) {
                	return "旧密码不能为空";
                }
                else {
                        System.out.println("none");
                        return "用户名不存在";
                }
                
        }
	    
	    
}
