package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Account;
import model.Login;

public class AccountDAOTest {

	
	
	Account account = new Account("minato", "1234", "minato@sukkiri.com", "湊　雄輔", 23);
	
	Login login = new Login("minato", "1234");
	
	AccountDAO accountDAO = new AccountDAO(); 
	
	Account accountDao = accountDAO.findByLogin(login);

//Success patarn	
	
	@Test
	public void testFindByLogin() {
		
		assertEquals(account.getUser_id(), accountDao.getUser_id());
//		assertEquals(account.getMail(), accountDao.getMail());
//		assertEquals(account.getName(), accountDao.getName());
//		assertEquals(account.getAge(), accountDao.getAge());

	}
	@Test
	public void testFindByLoginPass() {
		
		assertEquals(account.getPass(), accountDao.getPass());
		
	}
	
	@Test
	public void testFindByLoginMail() {
		
		assertEquals(account.getMail(), accountDao.getMail());
		
	}

	@Test
	public void testFindByLoginName() {
		
		assertEquals(account.getName(), accountDao.getName());
		
	}
	
	@Test
	public void testFindByLoginAge() {
		
		assertEquals(account.getAge(), accountDao.getAge());
		
	}

//fail Pattern
	// test fail pattarn
	
	Login login_f = new Login("sakai", "1234");
	
	AccountDAO acd = new AccountDAO();
	Account ac = accountDAO.findByLogin(login_f);
	
	@Test
	public void testFindByLoginFail_1() {
	
		assertEquals(null, ac);
		
	}

	Login login_f1 = new Login("minato", "12345");
	
	
	@Test
	public void testFindByLoginFail_2() {
//		assertNotNull(accountDAO.findByLogin(login_f1));
		assertEquals(null, accountDAO.findByLogin(login_f1));
		
	}
	
}

