
public class SavingsAccount
{
	
	private int AccountNumber;
	private String Name=new String();
	private String Address=new String();
	private int PhoneNum;
	private double Balance;
	private double InterestRate;
	
	
	public SavingsAccount()
	{
		AccountNumber=0;
		Name="";
		Address="";
		PhoneNum=0;
		Balance=0;
		InterestRate=0;
		
		
	}
	
	
	public SavingsAccount(int acc,String n,String add,int num,double b,double ir)
	{
		AccountNumber=acc;
		Name=n;
		Address=add;
		PhoneNum=num;
		Balance=b;
		InterestRate=ir;
		
		
	}
	
	public void checkBalance()
	{
		System.out.printf("\nName:  "+Name+"\nBalance:   "+Balance+"\n\n");
	}
	
	public void printStatement()
	{
		System.out.println("\nName:   "+Name+"\nAddress:   "+Address+"\nPhone Number:   "+PhoneNum+"\nAccount Number:   "+AccountNumber+"\nBalance:   "+Balance+"\n");
	}
	
	public Boolean transferAmount(SavingsAccount acc2,double amt)
	{
		if (amt>Balance)
			return false;
		else
		{
			this.withdraw(amt);
			acc2.deposit(amt);
			return true;
		}
	}
	
	public double Zakat()
	{
		double zakat=0;
		if (Balance>=20000)
		{
			zakat=(Balance*2.5)/100;
			return zakat;
		}
		else
			return 0;
	}
	
	
	
	public void deposit(double amt)
	{
		Balance=Balance + amt;
	}
	
	public void withdraw(double amt)
	{
		if(Balance>=amt)
		{
			Balance=Balance-amt;
		}
		else
			System.out.println("\nInvalid Transaction as Insufficient Balance");
	}
	
	public double addInterest()
	{
		return ((Balance*InterestRate) + Balance);
	}
	
	public double getBalance()
	{
		return Balance;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String getAddress()
	{
		return Address;
	}
	
	public double getPhoneNum()
	{
		return PhoneNum;
	}
	
	public int getAccNum()
	{
		return AccountNumber;
	}
	
	public void setInterest(double ir)
	{
		InterestRate=ir;
	}
	
	public SavingsAccount logIn(double AccNum)
	{
		if (AccountNumber==AccNum)
			return this;
		else
			return null;
	}
	
}

