package com.umk.modules.sys.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umk.base.repository.QueryFilter;
import com.umk.base.service.BaseService;
import com.umk.modules.sys.dao.UserDao;
import com.umk.modules.sys.entity.User;

@Service
public class UserService extends BaseService<User>{
	@Autowired
	private UserDao userDao;
	@SuppressWarnings("unchecked")
	@Override
	protected UserDao repository() {
		return userDao;
	}

	public User login(String userName,String pswd){
		return  userDao.findOne(new QueryFilter("SEQ_username",userName),new QueryFilter("SEQ_password",pswd));
	}
	
}
