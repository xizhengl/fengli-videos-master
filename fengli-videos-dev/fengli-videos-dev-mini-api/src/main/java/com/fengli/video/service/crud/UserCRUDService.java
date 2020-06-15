package com.fengli.video.service.crud;

import com.fengli.video.pojo.Users;

public interface UserCRUDService {
	
	
	public void saveUser(Users user);
	
	
	public void updateUser(Users user);
	
	public void updateUserExample(Users user);
	
	public void delete();
}
