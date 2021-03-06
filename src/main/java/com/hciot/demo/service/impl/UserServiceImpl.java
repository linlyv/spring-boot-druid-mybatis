package com.hciot.demo.service.impl;

import com.hciot.demo.dao.UserMapper;
import com.hciot.demo.entity.User;
import com.hciot.demo.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 用户Service实现
 *
 * @author BAIYEQIYA
 * @date 2017/12/22 15:07
 * @since JDK 1.8
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserMapper usermapper;
	
	
	
	@Override
	public void save(User user) {
		usermapper.insert(user);		
	}

	@Override
	public User getById(int id) throws Exception {
		return usermapper.selectByPrimaryKey(id);
	}
	@Override
	public User getUserByName(String name) {
		return usermapper.selectByPrimaryName(name);
	}

	@Override
	public User getUserByPassword(String password) {

		return usermapper.selectByPrimaryPassword(password);
	}

	@Override
	public List<User> getUserListByPassword(String password) {

		return usermapper.selectByPasswordToList(password);
	}

	@Override
	public List<User> getUserListByName(String name) {
		// TODO Auto-generated method stub
		return usermapper.selectByNameToList(name);
	}

	public List<User> getUserListByPasswordFillter(String password) {
		// TODO Auto-generated method stub
		return usermapper.selectByPasswordFillter(password);
	}

	public int updateByPrimary(User user) {
		// TODO Auto-generated method stub
		return usermapper.updateByPrimaryKeySelective(user);
	}
}
