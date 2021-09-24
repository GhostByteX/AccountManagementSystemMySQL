import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	
	static ArrayList<SavingsAccount> savingsAccountList=new ArrayList<SavingsAccount>();
	static ArrayList<CheckingAccount> checkingAccountList=new ArrayList<CheckingAccount>();
	public static int generateAccNum()
	{
		Random r=new Random();
		int acc=r.nextInt(100000);
		while (!isValid(acc))
			acc=r.nextInt(1000000);
		return acc;
	}
	
	
	public static boolean isValid(int a)
	{
		for (CheckingAccount i : checkingAccountList)
		{
			if(i.getAccNum()==a)
				return false;
		}
		for (SavingsAccount i : savingsAccountList)
		{
			if(i.getAccNum()==a)
				return false;
		}
		
		
		return true;
	}
	
	
	
	
	
	public static void main(String[] args)
	{
		
		double IntRate=2.5;
		@SuppressWarnings("resource")
		Scanner KB = new Scanner(System.in);
		//SavingsAccount A=new SavingsAccount(10001,"Usman","123ABC",9228058,40000);
		//A.withdraw(3000);
		/*A.checkBalance();
		A.deposit(5000);
		A.checkBalance();
		SavingsAccount B=new SavingsAccount(10002,"Ali","987XYZ",34385465,78000);
	    A.transferAmount(B, 450);
	    A.checkBalance();
	    B.checkBalance();
	    A.printStatement();
	    B.printStatement();
	    System.out.print("Zakat Is:  "+A.Zakat());
	    */
	    int option=0;
	    
	    do {
	    	System.out.println("\n_________________________MAIN MENU________________________\n\n"
	    			+ "\n1.Create a New Account\n\n2.Close an Account\n\n3.Login to your Account to do any Transaction"
	    			+ "\n\n4.Specify the Interest Rate\n\n5.Display All Details\n\n6.Display All Account Deductions"
	    			+ "\n\n7.EXIT\n\n");
	    	
	    	option=KB.nextInt();
	    	switch(option)
	    	{
	    	case 1:
	    		String Name;
	    		String Address;
	    		int AccNum;
	    		double Bal;
	    		int PhoneNum;
	    		int subopt=0;
	 
	    		System.out.println("\nPLEASE ENTER YOUR NAME\n");
	    		Name=KB.next();
	    		System.out.println("\nPLEASE ENTER YOUR ADDRESS\n");
	    		Address=KB.next();
	    	//	System.out.println("PLEASE ENTER YOUR ACCOUNT NUMBER\n");
	    		//AccNum=KB.nextDouble();
	    		AccNum=generateAccNum();
	    		System.out.println("\nYOUR ACCOUNT NUMBER IS:    "+AccNum+"\n\n");
	    		System.out.println("\nPLEASE ENTER YOUR PHONE NUMBER\n");
	    		PhoneNum=KB.nextInt();
	    		System.out.println("\nPLEASE ENTER YOUR BALANCE\n");
	    		Bal=KB.nextDouble();
	    		
	    		System.out.println("\nPRESS 1 TO OPEN SAVINGS ACCOUNT\n\nPRESS 2 TO OPEN CHECKING ACCOUNT\n");
	    		subopt=KB.nextInt();
	    		while (subopt!=1 && subopt!=2)
	    		{
	    			System.out.println("\nInvalid Option Chosen, Please Try Again\n\n");
	    			subopt=KB.nextInt();
	    		}
	    		if(subopt==1)
	    		{
	    			SavingsAccount SAcc1=new SavingsAccount(AccNum,Name,Address,PhoneNum,Bal,IntRate);
	    			savingsAccountList.add(SAcc1);
	    		}
	    		else if (subopt==2)
	    		{
	    			CheckingAccount CAcc1=new CheckingAccount(AccNum,Name,Address,PhoneNum,Bal);
	    			checkingAccountList.add(CAcc1);
	    		}
	    		
	    		break;
	    		
	    		
	    		
	    	case 2:
	    		int optt=0;
	    		System.out.println("\nPRESS 1 TO CLOSE A SAVINGS ACCOUNT\n\nPRESS 2 TO CLOSE A CHECKING ACCOUNT\n\n");
	    		optt=KB.nextInt();
	    		while(optt!=1 && optt!=2)
	    		{
	    			System.out.println("\nInvalid Option Chosen, Please Try Again\n\n");
	    			optt=KB.nextInt();
	    		}
	    		
	    		int accc=0;
	    		System.out.println("\nENTER THE ACCOUNT NUMBER TO CLOSE\n\n");
	    		accc=KB.nextInt();
	    		if(optt==1)
	    		{
	    			for (SavingsAccount i : savingsAccountList)
	    			{
	    				if(i.getAccNum()==accc)
	    				{
	    					savingsAccountList.remove(i);
	    					System.out.println("\nACCOUNT CLOSED\n");
	    					break;
	    				}
	    			}
	    		}
	    		
	    		
	    		else if (optt==2)
	    		{
	    			for (CheckingAccount i : checkingAccountList)
	    			{
	    				if(i.getAccNum()==accc)
	    				{
	    					checkingAccountList.remove(i);
	    					System.out.println("\nACCOUNT CLOSED\n");
	    					break;
	    				}
	    			}
	    		}
	    		break;
	    		
	    		
	    		
	    	case 3:
	    		
	    		int acc=0;
	    		
	    		System.out.println("\nPRESS 1 TO LOGIN TO SAVINGS ACCOUNT\n\nPRESS 2 TO LOGIN TO CHECKING ACCOUNT\n");
	    		subopt=KB.nextInt();
	    		while (subopt!=1 && subopt!=2)
	    		{
	    			System.out.println("\nInvalid Option Chosen, Please Try Again\n");
	    			subopt=KB.nextInt();
	    		}
	    		System.out.println("\nLog in to your Account by providing the Account Number\n");
	    		acc=KB.nextInt();
	    		SavingsAccount temp=new SavingsAccount();
	    		CheckingAccount temp1=new CheckingAccount();
	    		if(subopt==1)
	    		{
	    			//SavingsAccount temp2=new SavingsAccount();
	    			
	    			for(SavingsAccount i : savingsAccountList)
	    			{
	    				if(i.getAccNum()==acc)
	    					temp=i;
	    			}
	    			
	    			//temp=temp2.logIn(acc);
	    		}
	    		else if (subopt==2)
	    		{
	    			for(CheckingAccount i : checkingAccountList)
	    			{
	    				if(i.getAccNum()==acc)
	    					temp1=i;
	    			}
	    			//CheckingAccount temp2=new CheckingAccount();
	    			//temp1=temp2.logIn(acc);
	    		}
	    		if (subopt==1)
	    		{
		    		if(temp.getAccNum()!=0)
		    		{
			    		int opt2=0;
			    		do
			    		{
				    		System.out.println("\nTRANSACTION MENU SAVINGS ACCOUNT\n\n"
				    				+ "1. DEPOSIT\n"
				    				+ "\n2.WITHDRAW\n"
				    				+ "\n3.CHECK BALANCE\n"
				    				+ "\n4.PRINT STATEMENT\n"
				    				+ "\n5.CALCULATE ZAKAT\n"
				    				+ "\n6.TRANSFER AMMOUNT\n"
				    				+ "\n7.EXIT");
				    		opt2=KB.nextInt();
				    		switch(opt2)
				    		{
				    		
				    		case 1:
				    			double amt=0;
				    			System.out.println("\nEnter the Amount you want to Deposit\n");
				    			amt=KB.nextDouble();
				    			temp.deposit(amt);
				    			
				    			break;
				    			
				    		case 2:
				    			amt=0;
				    			System.out.println("\nEnter the Amount you want to Withdraw\n");
				    			amt=KB.nextDouble();
				    			temp.withdraw(amt);
				    			break;
				    			
				    		case 3:
				    			temp.checkBalance();
				    			break;
				    		
				    		case 4:
				    			temp.printStatement();
				    			break;
				    			
				    		case 5:
				    			System.out.print("\nThe Zakat due is:  "+temp.Zakat()+"\n\n");
				    			break;
				    			
				    		case 6:
				    			amt=0;
				    			int acc1=0;
				    			System.out.println("\nEnter the Amount you want to Transfer\n");
				    			amt=KB.nextDouble();
				    			System.out.println("\nEnter the Account Number you want to Transfer to\n");
				    			acc1=KB.nextInt();
				    			SavingsAccount t=new SavingsAccount();
				    			for (SavingsAccount i : savingsAccountList)
				    			{
				    				if (i.getAccNum()==acc1)
				    					t=i;
				    			}
				    			temp.transferAmount(t, amt);
				    			break;
				    			
				    		case 7:
				    			exit(0);
				    		
				    		
				    		}
			    		}while (opt2!=7);	
		    		}
		    		else
		    		{
		    			System.out.println("\nACCOUNT NOT FOUND\n\n");
		    		}
	    		}
	    		
	    		if (subopt==2)
	    		{
		    		if(temp1.getAccNum()!=0)
		    		{
			    		int opt2=0;
			    		do
			    		{
				    		System.out.println("\nTRANSACTION MENU SAVINGS ACCOUNT\n\n"
				    				+ "1. DEPOSIT\n"
				    				+ "\n2.WITHDRAW\n"
				    				+ "\n3.CHECK BALANCE\n"
				    				+ "\n4.PRINT STATEMENT\n"
				    				+ "\n5.TRANSFER AMMOUNT\n"
				    				+ "\n6.EXIT");
				    		opt2=KB.nextInt();
				    		switch(opt2)
				    		{
				    		
				    		case 1:
				    			double amt=0;
				    			System.out.println("\nEnter the Amount you want to Deposit\n");
				    			amt=KB.nextDouble();
				    			temp1.deposit(amt);
				    			
				    			break;
				    			
				    		case 2:
				    			amt=0;
				    			System.out.println("\nEnter the Amount you want to Withdraw\n");
				    			amt=KB.nextDouble();
				    			temp1.withdraw(amt);
				    			break;
				    			
				    		case 3:
				    			temp1.checkBalance();
				    			break;
				    		
				    		case 4:
				    			temp1.printStatement();
				    			break;
				    			
				    		
				    			
				    		case 5:
				    			amt=0;
				    			int acc1=0;
				    			System.out.println("\nEnter the Amount you want to Transfer\n");
				    			amt=KB.nextDouble();
				    			System.out.println("\nEnter the Account Number you want to Transfer to\n");
				    			acc1=KB.nextInt();
				    			CheckingAccount t=new CheckingAccount();
				    			for (CheckingAccount i : checkingAccountList)
				    			{
				    				if (i.getAccNum()==acc1)
				    					t=i;
				    			}
				    			temp1.transferAmount(t, amt);
				    			break;
				    			
				    		case 6:
				    			exit(0);
				    		
				    		
				    		}
			    		}while (opt2!=6);	
		    		}
		    		else
		    		{
		    			System.out.println("\nACCOUNT NOT FOUND\n\n");
		    		}
	    		}
	    		
	    		break;
	    		
	    		
	    	case 4:
	    		double ir=0;
	    		System.out.println("\nEnter the Interest Rate you want to set\n");
	    		ir=KB.nextDouble();
	    		
	    		IntRate=ir;
	    		break;
	    		
	    		
	    	case 5:
	    		
	    		System.out.println("\n\n CHECKING ACCOUNTS\n\n");
	    		for (CheckingAccount i : checkingAccountList)
	    		{
	    			i.printStatement();
	    		}
	    		
	    		System.out.println("\n\n SAVINGS ACCOUNTS\n\n");
	    		for (SavingsAccount i : savingsAccountList)
    			{
    				i.printStatement();
    			}
	    		break;
	    		
	    	case 6:
	    		System.out.println("\nNot Implemented \n\n");
	    		break;
	    		
	    		
	    	case 7:
	    		exit(0);
	    		
	    		
	    		
	    	}
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }while (option!=7);
	    
	    
	    
	    
	    
	    
	}

	private static void exit(int i) {
		// TODO Auto-generated method stub
		
	}
}
