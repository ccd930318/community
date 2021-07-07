package community.community.interceptor;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import community.community.mapper.UserAccountMapper;
import community.community.mapper.UserMapper;
import community.community.model.User;
import community.community.model.UserAccount;
import community.community.model.UserAccountExample;

@Service
public class SessionInterceptor implements HandlerInterceptor {
	
	@Autowired
	public UserAccountMapper userAccountMapper;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length != 0) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("accountId")) {
					String accountId = cookie.getValue();
					UserAccountExample userAccountExample = new UserAccountExample();
					userAccountExample.createCriteria().andAccountIdEqualTo(accountId);
					List<UserAccount>userAccounts =userAccountMapper.selectByExample(userAccountExample);
					if(userAccounts.size() != 0) {
						request.getSession().setAttribute("userAccount", userAccounts.get(0));
					}
					break;
				}
			}
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
