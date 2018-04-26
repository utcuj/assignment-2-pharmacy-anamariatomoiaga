package junit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import controller.UserController;

public class ReadUser {

	@Test
	public void test() {
		List<Object> user = UserController.read();
		assertTrue(user.size()!=0);
	}

}
