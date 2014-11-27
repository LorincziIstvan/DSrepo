package webapplicationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import edu.utcn.ds.lab1.LoginController;
import edu.utcn.ds.lab1.User;

public class LoginTest {
	private User testUser;
	private User testUser1;
	private User testUser2;
	@Before
	public void init() {
		testUser=new User("usernameTEST", "passwordTEST", "displayNameTEST", "1/1/1900", "addressTEST", 0.0, 0.0, "user");
		testUser1=new User("usernameTEST1", "passwordTEST", "displayNameTEST", "1/1/1900", "addressTEST", 0.0, 0.0, "admin");
		testUser2=new User("usernameTEST2", "wrongpassword", "displayNameTEST", "1/1/1900", "addressTEST", 0.0, 0.0, "user");
	}
	
	@Test
	public void testLoginUserSuccess() {
		
		LoginController loginBean=new LoginController();
		loginBean.setUser(testUser);
		try {
			assertEquals("user/simple_user",loginBean.login());
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void testLoginAdminSuccess() {
		
		LoginController loginBean=new LoginController();
		loginBean.setUser(testUser1);
		try {
			assertEquals("admin/admin",loginBean.login());
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void testLoginFailure() {
		
		LoginController loginBean=new LoginController();
		loginBean.setUser(testUser2);
		try {
			assertEquals("failure",loginBean.login());
		} catch (IOException e) {
			e.printStackTrace();
			fail();
		}
		
	}

}
