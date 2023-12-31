package pack;

import java.sql.*;
import java.util.*;
import java.lang.*;

public class Account implements ProjInterface {

	private String firstname;
	private String password;
	private String lastname;
	private ProjDate DOB;
	private String email;
	private String phoneno;
	private String address;
	boolean r = true;
	Scanner sin = new Scanner(System.in);
	Scanner sin2 = new Scanner(System.in);
	int c=0;
	String url = "jdbc:mysql://localhost:3306/OOPproject";
	String uname = "root";
	String pass = "hemanthmysql";

	@Override
	public void PrintMessage() {
		System.out.println("You are currently in account");
	}
	
	@Override
	public void Rating() {}
	
	
	public Account() {
	}

	public void setfname(String v1) {
		this.firstname = v1;
	}

	public void setlname(String v2) {
		this.lastname = v2;
	}

	public void setpassword(String v3) {
		this.password = v3;
	}

	public void setmail(String v4) {
		this.email = v4;
	}

	public void setphno(String v5) {
		this.phoneno = v5;
	}

	public void setdob(ProjDate v6) {
		this.DOB = v6;
	}

	public String getpassword() {
		return password;
	}

	public String getfname() {

		return firstname;
	}

	public String getlname() {
		return lastname;
	}

	public String getmail() {
		return email;
	}

	public String getphno() {
		return phoneno;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getaddress() {
		return this.address;
	}
	
	public void setc(int c) {
		this.c=c;
	}
	
	public int getc() {
		return this.c;
	}

	public void createTable() throws Exception{
		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";

		Connection c1 = DriverManager.getConnection(url, uname, pass);	
		
		try {
			String query="CREATE TABLE IF NOT EXISTS Account(\r\n"
			  		+ "PhoneNumber varchar(10) PRIMARY KEY NOT NULL,\r\n"
			  		+ "FirstName varchar(20) NOT NULL,\r\n"
			  		+ "LastName varchar(20),\r\n"
			  		+ "Email varchar(30) NOT NULL,\r\n"
			  		+ "DOB date NOT NULL,\r\n"
			  		+ "address varchar(50) NOT NULL, \r\n"
			  		+ "Passcode varchar(10) NOT NULL\r\n"
			  		+ ");";
			     PreparedStatement ps = c1.prepareStatement(query);
			 	 int n =ps.executeUpdate();

		}
		  catch(Exception e) {
			  System.out.println("Error");
		  }

	}

	
	public void create_account() throws Exception {
		
		createTable();

		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";

		Connection c1 = DriverManager.getConnection(url, uname, pass);
	
			
				System.out.println("Enter your first name ");
				String fn1 = sin.nextLine();
				System.out.println("Enter your last name ");
				String ln1 = sin.nextLine();
				System.out.println("Enter your email  ");
				String em = sin.nextLine();
				System.out.println("Enter your address");
				String add = sin.nextLine();
				
				String ph = "";
				boolean q= true;
				System.out.println("Enter your phoneno ");
				while(q) {
				ph = sin.nextLine();
				  if(ph.length()!=10) {
					  System.out.println(" *** Phone Number should be 10 digits ***");
				  }
				  else {
					  q=false;
				  }
				}

				ProjDate dob = new ProjDate();
				System.out.println("Enter your date of birth ");
				System.out.println("Format : YYYY MM DD ");

				boolean x=true;
				int y1=0;
				while(x) {
				System.out.println("Enter year");
				 y1 = sin2.nextInt();
				if(y1>2022) {
					System.out.println("*** Year should be less than 2022 ***");
				}
				else {
					x=false;
				}
				}
				
				dob.setyear(y1);
				while (r) {
					System.out.println("Enter month");
					int m1 = sin2.nextInt();
					r = dob.setmonth(m1);
				}
				r = true;
				while (r) {
					System.out.println("Enter date");
					int d1 = sin2.nextInt();
					r = dob.setdate(d1);
				}

				System.out.println("Set your password ");
				String p = "";
				boolean t3 = true;
				while(t3) {
				p = sin.nextLine();
				if(p.length() == 0) {
					System.out.println("Password cannot be empty\nEnter password again");
				}
				else {
					t3 = false;
				}
				}
				
				 
		        String date2 = dob.toString();
		          

		        String qu= "SELECT phonenumber FROM account WHERE phonenumber = '"+ph+"' and Passcode='"+p+"'";
		        String q2 = "select phonenumber,passcode from account where phonenumber = '"+ph+"' ";
		        Statement s = c1.createStatement();
		        ResultSet rs2 = s.executeQuery(q2);
		        int check = 0;
		        
		        if(rs2.next()) {
			        String q3= "SELECT * FROM account WHERE phonenumber = '"+ph+"' and Passcode='"+p+"'";
			        Statement s3 = c1.createStatement();
			        ResultSet rs3 = s3.executeQuery(q3);
			        if(rs3.next() == false) {
		        	System.out.println("\nAn account exists with this phone number but the entered password is wrong");
		        	check = -1;
			        }
		        }
		        ResultSet rs=s.executeQuery(qu);

				  if(rs.next()) {
					  
					  String date = dob.toString();
						this.setfname(fn1);
						this.setlname(ln1);
						this.setaddress(add);
						this.setdob(dob);
						this.setmail(em);
						this.setphno(ph);
						this.setpassword(p);
					  
						  System.out.println("*** Account updated ***");
						  String query1 = "UPDATE Account SET FirstName = '" + fn1 + "' where phonenumber = '" + ph +"' ";
						  String query2 = "UPDATE Account SET LastName = '" + ln1 + "' where phonenumber = '" + ph +"' ";
						  String query3 = "UPDATE Account SET Email = '" + em + "' where phonenumber = '" + ph+"' ";
						  String query4 = "UPDATE Account SET DOB = '" + date2 + "' where phonenumber = '" + ph +"' ";
						  String query5 ="UPDATE Account SET Address = '" + add + "' where phonenumber = '" + ph +"' ";
						  Statement s1 = c1.createStatement();
						  int count1 = s1.executeUpdate(query1);
						  s1 = c1.createStatement();
						  count1 = s1.executeUpdate(query2);
						  s1 = c1.createStatement();
						  count1 = s1.executeUpdate(query3);
						  s1 = c1.createStatement();
						  count1 = s1.executeUpdate(query4);
						  s1 = c1.createStatement();
						  count1 = s1.executeUpdate(query5);
				  }
				  
				  
				  if(check != -1) {
				
				
				String date = dob.toString();
				this.setfname(fn1);
				this.setlname(ln1);
				this.setaddress(add);
				this.setdob(dob);
				this.setmail(em);
				this.setphno(ph);
				this.setpassword(p);

				String query = "insert into Account values(?,?,?,?,?,?,?)";

				PreparedStatement ps = c1.prepareStatement(query);

				ps.setString(1, ph);
				ps.setString(2, fn1);
				ps.setString(3, ln1);
				ps.setString(4, em);
				ps.setString(5, date);
				ps.setString(6, add);
				ps.setString(7, p);

				int count = ps.executeUpdate();
				System.out.println("*** Account Created ***");
				  }
				  
				  
				r = false;
			
			
				//ps.close();

				c1.close();
			  setc(1);
				
		
	}

	public void login_account() throws Exception {

		createTable();
		
		
		
		
		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";

		try {

			Connection con = DriverManager.getConnection(url, uname, pass);

			System.out.println(" Enter your phone number to login  ");
			String ph = sin.nextLine();
			System.out.println(" Enter your password");
			String passcode = sin.nextLine();

			String query = "select * from Account where PhoneNumber = '" + ph + "' and passcode = '" + passcode + "'  ";

			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(query);

			if (rs.next()) {
				System.out.println("Successfully logged in.");
				setc(1);

				String d = rs.getString(5);
				ProjDate date1 = new ProjDate(d);

				this.setphno(ph);
				this.setfname(rs.getString(2));
				this.setlname(rs.getString(3));
				this.setmail(rs.getString(4));
				this.setdob(date1);
				this.setaddress(rs.getString(6));
				this.setpassword(rs.getString(7));
				System.out.println("Welcome "+this.getfname());

			} else {
				System.out.println(
						"Either the entered phone number or password is incorrect. Please try again. If you don't have an account please create a new account ");
				 setc(-1);
			}
			s1.close();
			con.close();

		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		

	}

	public void Edit() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";

		Connection con = DriverManager.getConnection(url, uname, pass);
		
		 boolean t= true;
		
		try {

			con = DriverManager.getConnection(url, uname, pass);

			System.out.println(" Enter your phone number to Edit   ");
			String ph = sin.nextLine();
			System.out.println(" Enter your password");
			String passcode = sin.nextLine();

			String query = "select * from Account where PhoneNumber = '" + ph + "' and passcode = '" + passcode + "'  ";

			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(query);

			if (rs.next()) {


				String d = rs.getString(5);
				ProjDate date1 = new ProjDate(d);

				this.setphno(ph);
				this.setfname(rs.getString(2));
				this.setlname(rs.getString(3));
				this.setmail(rs.getString(4));
				this.setdob(date1);
				this.setaddress(rs.getString(6));
				this.setpassword(rs.getString(7));
			} else {
				System.out.println(
						"Either the entered phone number or password is incorrect. Please try again.");
				t = false;
				
			}
			s1.close();
			con.close();

		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		
		
		
		
		
		
		int ch = 0;
		while(t != false) {
		while(ch != 6 ) {
		
		System.out.println("-------------------------------------");
		System.out.println("| Enter : 1 to edit first name      |");
		System.out.println("|         2 to edit last name       |");
		System.out.println("|         3 to edit password        |");
		System.out.println("|         4 to edit date of birth   |");
		System.out.println("|         5 to edit Email           |");
		System.out.println("|         6 to exit                 |");
		System.out.println("-------------------------------------");

		
        boolean y =true;
        while(y) {
        	try {
        		boolean e= true;
        		while(e) {
		ch = sin.nextInt();
		sin.nextLine();
		if(ch<1 || ch >6) {
			System.out.println("*** Enter valid input ***");
		}
		else {
			e=false;
		}
        		}
		y=false;
        	}
        	catch(Exception e) {
        		System.out.println("*** Enter valid data ***");
        		sin.next();
        	}
        	
        }
        
		switch (ch) {

		case 1:
			System.out.println("Enter your new first name: ");
			String nfn = sin2.nextLine();
			this.setfname(nfn);
			String query = "UPDATE Account SET FirstName = '" + nfn + "' where PhoneNumber = '" + this.phoneno + "' ";
			Statement s1 = con.createStatement();
			int count1 = s1.executeUpdate(query);
			break;

		case 2:
			System.out.println("Enter your new Last Name: ");
			String nln = sin.nextLine();
			this.setlname(nln);
			String query2 = "UPDATE Account SET LastName = '" + nln + "' where PhoneNumber = '" + this.phoneno + "' ";
			Statement s2 = con.createStatement();
			int count2 = s2.executeUpdate(query2);
			break;

		case 3:
			System.out.println("Enter your new  Passcode: ");
			String newpass = sin.nextLine();
			this.setpassword(newpass);
			String query3 = "UPDATE Account SET Passcode = '" + newpass + "' where PhoneNumber = '" + this.phoneno
					+ "' ";
			Statement s3 = con.createStatement();
			int count3 = s3.executeUpdate(query3);
			break;

		case 4:
			System.out.println("Enter your new Date of birth :");
			System.out.println("Formant : YYYY MM DD");
			ProjDate dob = new ProjDate();
			r = true;
			int y1 = sin2.nextInt();
			dob.setyear(y1);
			while (r) {
				int m1 = sin2.nextInt();
				r = dob.setmonth(m1);
			}
			r = true;
			while (r) {
				int d1 = sin2.nextInt();
				r = dob.setdate(d1);
			}
			String date = dob.toString();
			System.out.println("New DOB is: " + date);
			String query4 = "UPDATE Account SET DOB = '" + date + "' where PhoneNumber = '" + this.phoneno + "' ";
			Statement s4 = con.createStatement();
			int count4 = s4.executeUpdate(query4);
			break;

		case 5:
			System.out.println("Enter your new Email");
			String ne = sin.nextLine();
			this.setmail(ne);
			System.out.println("Email SET");
			String query5 = "UPDATE Account SET Email = '" + ne + "' where PhoneNumber = '" + this.phoneno + "' ";
			Statement s5 = con.createStatement();
			int count5 = s5.executeUpdate(query5);
			break;

		case 6:
			break;

		default:
			System.out.println("Enter a valid number.");

		}
		}
		}
	}

	public void getdetails() {
		
		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";
		boolean t =true;
		
		try {

			Connection con = DriverManager.getConnection(url, uname, pass);

			System.out.println(" Enter your phone number to get your details:  ");
			String ph = sin.nextLine();
			System.out.println(" Enter your password");
			String passcode = sin.nextLine();
            
			String query = "select * from Account where PhoneNumber = '" + ph + "' and passcode = '" + passcode + "'  ";

			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(query);

			if (rs.next()) {

				String d = rs.getString(5);
				ProjDate date1 = new ProjDate(d);

				this.setphno(ph);
				this.setfname(rs.getString(2));
				this.setlname(rs.getString(3));
				this.setmail(rs.getString(4));
				this.setdob(date1);
				this.setaddress(rs.getString(6));
				this.setpassword(rs.getString(7));
			} else {
				System.out.println(
						"Either the entered phone number or password is incorrect. Please try again." );
				     t=false;
	
		}
		}catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		
		if(t==true) {
		System.out.println("First Name    :" + this.getfname());
		System.out.println("Last  Name    :" + this.getlname());
		System.out.println("Date of Birth :" + this.DOB.toString());
		System.out.println("Email         :" + this.getmail());
		System.out.println("Phone number  :" + this.getphno());
		}
	}
	
	
	public void Delete() throws SQLException  {
	     String url="jdbc:mysql://localhost:3306/OOPproject";
	     String uname="root";
	     String pass="hemanthmysql";
	     Connection con = DriverManager.getConnection(url,uname,pass);

		boolean t = true;
		String ph = "";
		String passcode = "";
		 try {
			System.out.println(" Enter your phone number to delete your account :  ");
			ph = sin.nextLine();
			System.out.println(" Enter your password");
			passcode = sin.nextLine();
            
			String query = "select * from Account where PhoneNumber = '" + ph + "' and passcode = '" + passcode + "'  ";

			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(query);

			if (rs.next()) {

				String d = rs.getString(5);
				ProjDate date1 = new ProjDate(d);

				this.setphno(ph);
				this.setfname(rs.getString(2));
				this.setlname(rs.getString(3));
				this.setmail(rs.getString(4));
				this.setdob(date1);
				this.setaddress(rs.getString(6));
				this.setpassword(rs.getString(7));
			} else {
				System.out.println(
						"Either the entered phone number or password is incorrect. Please try again." );
				     t=false;
	
		}
		}catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		} 
     
	      if(t == true) {
		  String query1= "DELETE FROM account WHERE phonenumber = '"+ph+"' and Passcode='"+passcode+"'";
		  Statement s1 = con.createStatement();
		  int q=s1.executeUpdate(query1);
		  System.out.println("*** Account deleted Sucessfully ***\n");
	                   }

	  }
	  
 
 
 public void checking() throws SQLException{
	 String url="jdbc:mysql://localhost:3306/OOPproject";
     String uname="root";
     String pass="hemanthmysql";
     Connection con = DriverManager.getConnection(url,uname,pass);
    
     System.out.println("Enter your Phone Number to check if account exists");
     String ph=sin2.nextLine();
     String query ="SELECT phonenumber FROM account WHERE phonenumber = '"+ph+"'";
     Statement s = con.createStatement();
	  ResultSet rs=s.executeQuery(query);
	  if(rs.next()) {
		  System.out.println("Account with the Phone Number exists\n");
	  }
	  else {
		  System.out.println("NO Account Is Present Please Create An Account\n");
	  }
 
}
 }
