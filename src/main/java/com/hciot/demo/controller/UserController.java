package com.hciot.demo.controller;

import com.hciot.demo.entity.User;
import com.hciot.demo.service.UserService;
import com.hciot.demo.service.impl.UserServiceImpl;

import java.util.Date;
import java.util.List;
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
 * @date 2018/5/20 12:01
 * @since JDK 1.8
 */
@Controller
public class UserController {
	@Autowired
    private UserServiceImpl userServiceImpl;
	//___________________作 业 3 给定户名返回密码_____________________________________________
	 @RequestMapping(value="/findbyname",method = RequestMethod.GET)
	 @ResponseBody
	 public String findbyname(String name) {
		 User user = new User();
		 user=userServiceImpl.getUserByName(name); 
		 if (user!=null) {
			 return "用户："+name+"  密码："+user.getPassword();	
		 }else {
			 return "用户找不到";	
		 }
	 }
    
    
   
   //____________________作 业 4 给定密码返回用户名______________________________________________
    @RequestMapping(value="/finduser",method = RequestMethod.GET)
    @ResponseBody
    public String loginVerify(String password) throws Exception {

    	System.out.println("密码："+password); 	
    	List<User> user;
    	
    	System.out.println("finduser被调用");
    	user=userServiceImpl.getUserListByPasswordFillter(password);
    	if (!user.isEmpty()) {		
    			String us[] = new String[user.size()]; 
    			StringBuffer sB = new StringBuffer();
    			for (int i = 0; i < us.length; i++) { 				
					us[i]="找到用户："+user.get(i).getName()+"  密码："+user.get(i).getPassword()+"<br/>";
					sB.append(us[i]);
    			}		  			 
    		    return sB.toString();
		}
    	else {
    		return "找不到用户："+"密码"+password+"找不到";
    		//return null;
    	}	
     }
    
    @RequestMapping(value="/biaodan/findbypassword",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByPassword(String name,String password) throws Exception {
    	List<User> u;
    	u = userServiceImpl.getUserListByPassword(password);
    	
        return u;
    }  
    @RequestMapping(value="/biaodan/findUsers",method = RequestMethod.GET)
    @ResponseBody
    public List<User> findByPassword2(String name,String password) throws Exception {
    	List<User> u;
    	u = userServiceImpl.getUserListByPasswordFillter(password);
    	
        return u;
    }  
    
}
