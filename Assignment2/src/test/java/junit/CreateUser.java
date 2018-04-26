package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.UserController;
import model.User;

public class CreateUser {

	@Test
	public void test() {
		User u = new User("Diana","Cluj","user","pass",false);
		int x = UserController.create(u);
		assertTrue(x!=-1);
		
	}

}
