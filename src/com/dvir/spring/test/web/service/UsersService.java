package com.dvir.spring.test.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvir.spring.test.web.dao.User;
import com.dvir.spring.test.web.dao.UsersDao;

@Service("usersService")
public class UsersService {

	private UsersDao usersDao;

	public UsersDao getUsersDao() {
		return usersDao;
	}

	@Autowired
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	public void create(User user) {
		usersDao.create(user);
	}

	public boolean exits(String username) {
		return usersDao.exits(username);
	}
}
