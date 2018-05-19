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
}
