package cn.shiro.ch2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author zjc
 * @version 2016/7/24 13:20
 * @description
 */
public class AuthenticatorTest {

	private void login(String configFile) {
		//1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<SecurityManager> factory =
				new IniSecurityManagerFactory(configFile);
		//2、得到SecurityManager实例并绑定给SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		//3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
		subject.login(token);
	}


	@Test
	public void testAllSuccessfulStrategyWithSuccess() {
		login("classpath:shiro-authenticator-all-success.ini");
		Subject subject = SecurityUtils.getSubject();
		//得到一个身份集合，其包含了Realm验证成功的身份信息(用户名,在realm的返回值可以重写)
		PrincipalCollection principalCollection = subject.getPrincipals();
		System.out.println(principalCollection.asList());
		Assert.assertEquals(2, principalCollection.asList().size());
	}

	@Test(expected = UnknownAccountException.class)
	public void testAllSuccessfulStrategyWithFail() {
		login("classpath:shiro-authenticator-all-fail.ini");
		Subject subject = SecurityUtils.getSubject();
		//得到一个身份集合，其包含了Realm验证成功的身份信息(用户名,在realm的返回值可以重写)
		PrincipalCollection principalCollection = subject.getPrincipals();
		System.out.println(principalCollection.asList());
		Assert.assertEquals(2, principalCollection.asList().size());
	}

	@Test
	public void testAtLeastOneSuccessfulStrategyWithSuccess() {
		login("classpath:shiro-authenticator-atleastOne-success.ini");
		Subject subject = SecurityUtils.getSubject();
		//得到一个身份集合，其包含了Realm验证成功的身份信息(用户名,在realm的返回值可以重写)
		PrincipalCollection principalCollection = subject.getPrincipals();
		System.out.println(principalCollection.asList());
		Assert.assertEquals(2, principalCollection.asList().size());
	}

	@Test
	public void testFirstSuccessfulStrategyWithSuccess() {
		login("classpath:shiro-authenticator-first-success.ini");
		Subject subject = SecurityUtils.getSubject();
		//得到一个身份集合，其包含了Realm验证成功的身份信息(用户名,在realm的返回值可以重写)
		PrincipalCollection principalCollection = subject.getPrincipals();
		System.out.println(principalCollection.asList());
		Assert.assertEquals(1, principalCollection.asList().size());
	}

	//有且仅有一个通过
	@Test
	public void testOnlyOneSuccessfulStrategyWithSuccess() {
		login("classpath:shiro-authenticator-onlyone-success.ini");
		Subject subject = SecurityUtils.getSubject();
		//得到一个身份集合，其包含了Realm验证成功的身份信息(用户名,在realm的返回值可以重写)
		PrincipalCollection principalCollection = subject.getPrincipals();
		System.out.println(principalCollection.asList());
		Assert.assertEquals(1, principalCollection.asList().size());
	}

	//至少通过两个realm
	@Test
	public void testAtLeastTwoSuccessfulStrategyWithSuccess() {
		login("classpath:shiro-authenticator-atleastTwo-success.ini");
		Subject subject = SecurityUtils.getSubject();
		//得到一个身份集合，其包含了Realm验证成功的身份信息(用户名,在realm的返回值可以重写)
		PrincipalCollection principalCollection = subject.getPrincipals();
		System.out.println(principalCollection.asList());
		Assert.assertEquals(1, principalCollection.asList().size());
	}

	@After
	public void tearDown() throws Exception {
		ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
	}
}
