package community.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import community.community.mapper.UserMapper;
import community.community.model.User;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	
	public void createOrUpdate(User user) {
		User dbUser = userMapper.findByAccountId(user.getAccountId());
		if(dbUser == null) {
			user.setGmtCreate(System.currentTimeMillis());
			user.setGmtModified(user.getGmtCreate());
			userMapper.insert(dbUser);
		}else {
			dbUser.setGmtModified(user.getGmtCreate());
			dbUser.setToken(user.getToken());
			dbUser.setName(user.getName());
			dbUser.setAvatarUrl(user.getAvatarUrl());
			userMapper.update(dbUser);
		}
	}
}
