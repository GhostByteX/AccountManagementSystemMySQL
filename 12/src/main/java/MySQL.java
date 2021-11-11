import java.sql.*;
class MySQL extends PersHand{
	
	public void displayall()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/accountmanagementsystem","root","usmanmalik740");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select* from savingsaccount");
			
			System.out.print("\n 		SAVINGS ACCOUNTS\n\n");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"               "+rs.getString(2)+"               "+rs.getString(3) +"               "+rs.getInt(4)+"               "+rs.getInt(5)+"\n");
			}
			
			System.out.print("\n 		CHECKING ACCOUNTS\n\n");
			
			rs=stmt.executeQuery("select* from checkingaccount");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"               "+rs.getString(2)+"               "+rs.getString(3) +"               "+rs.getInt(4)+"               "+rs.getInt(5)+"\n");
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	
	public void addaccount(int accnum,String N,String Add,int Pno, int Bal,int choice)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/accountmanagementsystem","root","usmanmalik740");
		if (choice==1)
		{
			String sql="INSERT INTO savingsaccount(AccNum,Name,Address,PhoneNo,Balance) VALUES(?,?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1,accnum);
			statement.setString(2, N);
			statement.setString(3, Add);
			statement.setInt(4,Pno);
			statement.setInt(5,Bal);
			int rowsInserted=statement.executeUpdate();
			if(rowsInserted>0)
			{
				System.out.print("A New Savings Account Successfully Added to the Database\n");
			}
					
			
			
		}
		
		else if (choice==2)
		{
			String sql="INSERT INTO checkingaccount(AccNum,Name,Address,PhoneNo,Balance) VALUES(?,?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1,accnum);
			statement.setString(2, N);
			statement.setString(3, Add);
			statement.setInt(4,Pno);
			statement.setInt(5,Bal);
			int rowsInserted=statement.executeUpdate();
			if(rowsInserted>0)
			{
				System.out.print("A New Checking Account Successfully Added to the Database\n");
			}
		}
		
		
		
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	public void delaccount(int accnum,int choice)
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/accountmanagementsystem","root","usmanmalik740");
		if (choice==1)
		{
			String sql="DELETE FROM savingsaccount WHERE AccNum=?";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1,accnum);
			
			int rowsDeleted=statement.executeUpdate();
			if(rowsDeleted>0)
			{
				System.out.print("\nSavings Account No "+accnum+" Closed Successfully\n\n");
			}
			
			
		}
		
		else if (choice==2)
		{
			String sql="DELETE FROM checkingaccount WHERE AccNum=?";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1,accnum);
			
			int rowsDeleted=statement.executeUpdate();
			if(rowsDeleted>0)
			{
				System.out.print("\nChecking Account No "+accnum+" Closed Successfully\n\n");
			}
			
		}
		
		
		
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}

	
}