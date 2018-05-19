package com.hciot.demo.controller;

import com.hciot.demo.entity.User;
import com.hciot.demo.service.UserService;
import com.hciot.demo.service.impl.UserServiceImpl;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Demo控制器
 *
 * @author BAIYEQIYA
 * @date 2017/12/22 12:01
 * @since JDK 1.8
 */
@Controller
public class DemoController {
	@Autowired
    private UserServiceImpl userServiceImpl;

    
	private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/register")
    @ResponseBody
    public String userregister(String name,String password,String email,String wechat) throws Exception {
    	counter.incrementAndGet();
    	System.out.println(counter);
    	System.out.println(name);
    	System.out.println(password);
    	System.out.println(email);
    	System.out.println(wechat);
    	User user = new User();
    	

    	user.setName(name);
    	user.setPassword(password);
    	Date date = new Date();
    	user.setTime(date);
    	user.setEmail(email);
    	user.setWechat(wechat);
    	userServiceImpl.save(user);
        return "<html><body>\r\n" + 	
				"<h1 >注册成功<h1>\r\n" + 
				"</body></html>";
    }
    
}
