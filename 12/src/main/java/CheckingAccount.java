
public class CheckingAccount
{
	


	private int AccountNumber;
	private String Name=new String();
	private String Address=new String();
	private int PhoneNum;
	private double Balance;
	private double Tax;
	
	
	public CheckingAccount()
	{
		AccountNumber=0;
		Name="";
		Address="";
		PhoneNum=0;
		Balance=0;
		Tax=0;
		
		
	}
	
	
	public CheckingAccount(int acc,String n,String add,int num,double b)
	{
		AccountNumber=acc;
		Name=n;
		Address=add;
		PhoneNum=num;
		Balance=b;
		Tax=1.6;;
		
		
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
		else if (amt-Balance>5000)
		{
				System.out.println("\nInsufficient Balance to Make the Transaction, You can withdraw maximum of 5000 PKR more than your Balance\n");
		}
		else
		{
			Balance=Balance-amt;
		}
			
	}
	
	public void checkBalance()
	{
		System.out.printf("\n\nName:  "+Name+"\nBalance:   "+Balance+"\n\n");
	}
	
	public Boolean transferAmount(CheckingAccount acc2,double amt)
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
	public void printStatement()
	{
		System.out.println("\n\nName:   "+Name+"\nAddress:   "+Address+"\nPhone Number:   "+PhoneNum+"\nAccount Number:   "+AccountNumber+"\nBalance:   "+Balance+"\n");
	}
	
	public void addTax()
	{
		Balance=Balance*Tax + Balance;
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
	
	public int getPhoneNum()
	{
		return PhoneNum;
	}
	
	public int getAccNum()
	{
		return AccountNumber;
	}
	
	public CheckingAccount logIn(double AccNum)
	{
		if (AccountNumber==AccNum)
			return this;
		else
			return null;
	}
	
}


	
	
	
	
	

