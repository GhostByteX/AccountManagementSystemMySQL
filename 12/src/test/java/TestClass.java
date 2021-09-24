import static org.junit.Assert.*;

import org.junit.Test;

public class TestClass {

	@SuppressWarnings("deprecation")
	@Test
	public void setInterestRateTest() {
		SavingsAccount s=new SavingsAccount();
		double temp=0;
		temp=s.setInterest(3.5);
		assertEquals(temp,3.5,0.1);
	}

	@Test
	public void setInterestRateTest2() {
		SavingsAccount s=new SavingsAccount();
		double temp=0;
		temp=s.setInterest(2.5);
		assertNotEquals(temp,3.5,0.1);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void DepositTest() {
		SavingsAccount s=new SavingsAccount();
		s.deposit(4000);
		double temp = s.getBalance();
		assertEquals(temp,4000,0.1);
	}

	@Test
	public void DepositTest2() {
		SavingsAccount s=new SavingsAccount();
		double temp=0;
		s.deposit(3000);
		temp=s.getBalance();
		assertNotEquals(temp,4000,0.1);
	}

	
	@Test
	public void ZakatTest1() {
		SavingsAccount s=new SavingsAccount();
		double temp=0;
		s.deposit(500000);
		temp=s.Zakat();
		double result=s.getBalance()*(2.5/100);
		assertEquals(result,temp,0.1);
	}

	@Test
	public void ZakatTest2() {
		SavingsAccount s=new SavingsAccount();
		double temp=0;
		s.deposit(500);
		temp=s.Zakat();
		double result=s.getBalance()*(2.5/100);
		assertNotEquals(result,temp,0.1);
	}
	
	
	
	
	@Test
	public void TransferTest1() {
		SavingsAccount s=new SavingsAccount();
		SavingsAccount s2=new SavingsAccount();
		boolean temp;
		s.deposit(500000);
		temp=s.transferAmount(s2, 1000);
		assertEquals(true,temp);
	}
	
	@Test
	public void TransferTest2() {
		SavingsAccount s=new SavingsAccount();
		SavingsAccount s2=new SavingsAccount();
		boolean temp;
		s.deposit(500);
		temp=s.transferAmount(s2, 1000);
		assertEquals(false,temp);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void DepositTest3() {
		CheckingAccount s=new CheckingAccount();
		s.deposit(4000);
		double temp = s.getBalance();
		assertEquals(temp,4000,0.1);
	}

	@Test
	public void DepositTest4() {
		CheckingAccount s=new CheckingAccount();
		double temp=0;
		s.deposit(3000);
		temp=s.getBalance();
		assertNotEquals(temp,4000,0.1);
	}

	
	
	
	@Test
	public void TransferTest3() {
		CheckingAccount s=new CheckingAccount();
		CheckingAccount s2=new CheckingAccount();
		boolean temp;
		s.deposit(500000);
		temp=s.transferAmount(s2, 1000);
		assertEquals(true,temp);
	}
	
	@Test
	public void TransferTest4() {
		CheckingAccount s=new CheckingAccount();
		CheckingAccount s2=new CheckingAccount();
		boolean temp;
		s.deposit(500);
		temp=s.transferAmount(s2, 1000);
		assertEquals(false,temp);
	}
	
	
	
}
