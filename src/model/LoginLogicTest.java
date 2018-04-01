package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginLogicTest {

	//成功の場合
	Login login = new Login("minato", "1234");
	
	LoginLogic ll = new LoginLogic();
	
	boolean ll_result = ll.execute(login);
	
	//失敗の場合
	Login login_f = new Login("minato", "12345");
	boolean ll_result2 = ll.execute(login_f);
	
	
	
	@Test
	public void testExecute() {
		assertEquals(true, ll_result);
	}


	@Test
	public void testExecute2() {
		assertEquals(false, ll_result2);
	}
	
}
