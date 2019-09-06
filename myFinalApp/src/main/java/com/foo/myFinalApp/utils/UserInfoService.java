package com.foo.myFinalApp.utils;

import com.foo.myFinalApp.entity.User;

public interface UserInfoService {

	/** find user by account **/
	public User findUser(String account);

	/** update user **/
	public User updateUser(User user);
}
