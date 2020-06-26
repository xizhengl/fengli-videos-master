package com.fengli.video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fengli.video.pojo.Users;
import com.fengli.video.service.crud.UserCRUDService;
import com.fengli.video.utils.FengliJsonResult;

@RestController
@RequestMapping("/crud")
public class UserCRUDController {
	
	@Autowired
	private UserCRUDService userCRUDService;
	
	@RequestMapping("/save")
	public FengliJsonResult save() {
		
		Users user = new Users("1001", "test-saveuser-1001",
				"123456", "/path", "慕课网", null, null, null);
		userCRUDService.saveUser(user);
		
		return FengliJsonResult.ok();
	}
	
	@RequestMapping("/update")
	public FengliJsonResult update() {
		
		Users user = new Users("1001", "test-saveuser-1111",
				"77777", "/path000", "慕课网好牛~", null, null, null);
		userCRUDService.updateUser(user);
		
		return FengliJsonResult.ok();
	}
	
	@RequestMapping("/update2")
	public FengliJsonResult update2() {
		
		Users user = new Users("1001", null,
				"9999", "/path000999", "慕课网好牛十分牛~", null, null, null);
		userCRUDService.updateUser(user);
		
		return FengliJsonResult.ok();
	}
	
	@RequestMapping("/delUser")
	public FengliJsonResult delUser() {
		
		userCRUDService.delete();
		
		return FengliJsonResult.ok();
	}
}
