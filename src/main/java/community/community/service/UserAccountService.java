package community.community.service;

import java.util.List;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import community.community.mapper.UserAccountMapper;
import community.community.model.UserAccount;
import community.community.model.UserAccountExample;

@Service
public class UserAccountService {
	
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	
	public void createOrUpdate(UserAccount userAccount) {
		UserAccountExample userAccountExample = new UserAccountExample();
		userAccountExample.createCriteria().andAccountIdEqualTo(userAccount.getAccountId());
		List<UserAccount> users = userAccountMapper.selectByExample(userAccountExample);
		if(users.size() == 0) {
			userAccount.setGmtCreate(System.currentTimeMillis());
			userAccount.setGmtModified(userAccount.getGmtCreate());
			userAccountMapper.insert(userAccount);
		}else {
			UserAccount user =users.get(0);
			UserAccount userUpdate = new UserAccount();
			user.setGmtModified(userAccount.getGmtCreate());
			user.setName(userAccount.getName());
			user.setEmail(userAccount.getEmail());
			user.setAvatarUrl(userAccount.getAvatarUrl());
			UserAccountExample example = new UserAccountExample();
			example.createCriteria().andAccountIdEqualTo(user.getAccountId());
			userAccountMapper.updateByExampleSelective(userUpdate, example);
		}
	}
}
