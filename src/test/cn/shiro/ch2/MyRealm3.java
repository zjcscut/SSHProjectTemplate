package cn.shiro.ch2;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author zjc
 * @version 2016/7/24 1:33
 * @description
 */
public class MyRealm3 implements Realm {

	@Override
	public String getName() {
		return "myRealm3";
	}

	@Override
	public boolean supports(AuthenticationToken authenticationToken) {
		//仅仅支持UsernamePasswordToken类型的token
		return authenticationToken instanceof UsernamePasswordToken;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		String username = (String) authenticationToken.getPrincipal(); //获取用户名
		String password = new String((char[]) authenticationToken.getCredentials()); //获取用户密码
		if (!"zhang".equals(username)) {
			throw new UnknownAccountException(); //如果用户名错误
		}

		if (!"123".equals(password)) {
			throw new IncorrectCredentialsException(); //如果密码错误
		}

		//如果身份认证验证成功，返回一个AuthenticationInfo实现；
		return new SimpleAuthenticationInfo(username + "@163.com", password, getName());
	}
}
