package cn.shiro.ch3;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author zjc
 * @version 2016/7/24 14:06
 * @description
 */
public class TestRole extends BaseTest {

	@Test
	public void testHasRole() {
		login("classpath:ch3/shiro-role.ini", "zhang", "123");
        //判断拥有角色：role1
		Assert.assertTrue(subject().hasRole("role1"));
        //判断拥有角色：role1 and role2
		Assert.assertTrue(subject().hasAllRoles(Arrays.asList("role1", "role2")));
        //判断拥有角色：role1 and role2 and !role3
		boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));
		Assert.assertEquals(true, result[0]);
		Assert.assertEquals(true, result[1]);
		Assert.assertEquals(false, result[2]);
	}

	//如果zhang这个用户没有role3角色会抛出UnauthorizedException
	@Test(expected = UnauthorizedException.class)
	public void testCheckRole() {
		login("classpath:ch3/shiro-role.ini", "zhang", "123");
        //断言拥有角色：role1
		subject().checkRole("role1");
        //断言拥有角色：role1 and role3 失败抛出异常
		subject().checkRoles("role1", "role3");
	}
}
