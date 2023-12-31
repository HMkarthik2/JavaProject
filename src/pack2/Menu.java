package pack2;
import pack.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.*;

import pack.Account;
import pack.ProjInterface;

public class Menu extends Account implements ProjInterface {

Scanner in = new Scanner(System.in);
	
	int temp=0;
	
	public void setTemp(int x){
		this.temp = x;
	}
	
	public int getTemp() {
		return temp;
	}
	
	@Override
	public void PrintMessage() {
		System.out.println("You are currently viewing menu");
	}

	public int SelectMenu() throws SQLException, FileNotFoundException {

		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";
		Connection c1 = DriverManager.getConnection(url, uname, pass);
    
		try {
			String query="CREATE TABLE IF NOT EXISTS  bangloremenu(\r\n"
			  		+ "id int PRIMARY KEY NOT NULL,\r\n"
			  		+ " item varchar(30) NOT NULL,\r\n"
			  		+ " price varchar(10)\r\n"
			  		+ ");";
			     PreparedStatement ps = c1.prepareStatement(query);
			 	 int n =ps.executeUpdate();

		}
		  catch(Exception e) {
			  System.out.println("Error");
		  }
		
		try {
			String query="CREATE TABLE IF NOT EXISTS   chennaimenu(\r\n"
			  		+ "id int PRIMARY KEY NOT NULL,\r\n"
			  		+ " item varchar(50) NOT NULL,\r\n"
			  		+ " price varchar(10)\r\n"
			  		+ ");";
			     PreparedStatement ps = c1.prepareStatement(query);
			 	 int n =ps.executeUpdate();

		}
		  catch(Exception e) {
			  System.out.println("Error");
		  }
		
		try {
			String query="CREATE TABLE IF NOT EXISTS   vizagmenu(\r\n"
			  		+ "id int PRIMARY KEY NOT NULL,\r\n"
			  		+ " item varchar(30) NOT NULL,\r\n"
			  		+ " price varchar(10)\r\n"
			  		+ ");";
			     PreparedStatement ps = c1.prepareStatement(query);
			 	 int n =ps.executeUpdate();

		}
		  catch(Exception e) {
			  System.out.println("Error");
		  }
		
		
		try {
			String query="CREATE TABLE IF NOT EXISTS   vijayawadamenu(\r\n"
			  		+ "id int PRIMARY KEY NOT NULL,\r\n"
			  		+ " item varchar(30) NOT NULL,\r\n"
			  		+ " price varchar(10)\r\n"
			  		+ ");";
			     PreparedStatement ps = c1.prepareStatement(query);
			 	 int n =ps.executeUpdate();

		}
		  catch(Exception e) {
			  System.out.println("Error");
		  }
		
		try {
			String query="CREATE TABLE IF NOT EXISTS   hydmenu(\r\n"
			  		+ "id int PRIMARY KEY NOT NULL,\r\n"
			  		+ " item varchar(30) NOT NULL,\r\n"
			  		+ " price varchar(10)\r\n"
			  		+ ");";
			     PreparedStatement ps = c1.prepareStatement(query);
			 	 int n =ps.executeUpdate();

		}
		  catch(Exception e) {
			  System.out.println("Error");
		  }
		
		
		
	    try {
	    	String sql ="insert into chennaimenu values(?,?,?)";
	    	
	    	PreparedStatement ps=c1.prepareStatement(sql);
	    	Scanner sc=new Scanner(new File("C:/Users/heman/OneDrive/Desktop/SQL/newCHENNAI.csv"));
	    	while(sc.hasNext())
	    	{
	    		String[] str = sc.nextLine().split(",");
	    		ps.setInt(1,Integer.parseInt(str[0]));
	    		ps.setString(2,str[1]);
	    		ps.setString(3,str[2]);
	    		ps.executeUpdate();
	    	}
	    	
	    }
	    
	    catch(Exception e){
	    	System.out.println(e);
	    }
		
		
	    try {
	    	String sql ="insert into hydmenu(id,item,price) values(?,?,?)";
	    	
	    	PreparedStatement ps=c1.prepareStatement(sql);
	    	Scanner sc=new Scanner(new File("C:/Users/heman/OneDrive/Desktop/SQL/newHYD.csv"));
	    	while(sc.hasNext())
	    	{
	    		String[] str = sc.nextLine().split(",");
	    		ps.setInt(1,Integer.parseInt(str[0]));
	    		ps.setString(2,str[1]);
	    		ps.setString(3,str[2]);
	    		ps.executeUpdate();
	    	}
	    	
	    }
	    
	    catch(Exception e){
	    	System.out.println(e);
	    }
	    
	    try {
	    	String sql ="insert into bangloremenu(id,item,price) values(?,?,?)";
	    	
	    	PreparedStatement ps=c1.prepareStatement(sql);
	    	Scanner sc=new Scanner(new File("C:/Users/heman/OneDrive/Desktop/SQL/newBANG.csv"));
	    	while(sc.hasNext())
	    	{
	    		String[] str = sc.nextLine().split(",");
	    		ps.setInt(1,Integer.parseInt(str[0]));
	    		ps.setString(2,str[1]);
	    		ps.setString(3,str[2]);
	    		ps.executeUpdate();
	    	}
	    	
	    }
	    
	    catch(Exception e){
	    	System.out.println(e);
	    }
	    
	    try {
	    	String sql ="insert into vizagmenu(id,item,price) values(?,?,?)";
	    	
	    	PreparedStatement ps=c1.prepareStatement(sql);
	    	Scanner sc=new Scanner(new File("C:/Users/heman/OneDrive/Desktop/SQL/newVIZAG.csv"));
	    	while(sc.hasNext())
	    	{
	    		String[] str = sc.nextLine().split(",");
	    		ps.setInt(1,Integer.parseInt(str[0]));
	    		ps.setString(2,str[1]);
	    		ps.setString(3,str[2]);
	    		ps.executeUpdate();
	    	}
	    	
	    }
	    
	    catch(Exception e){
	    	System.out.println(e);
	    }
	    
	    try {
	    	String sql ="insert into VIJAYAWADAmenu(id,item,price) values(?,?,?)";
	    	
	    	PreparedStatement ps=c1.prepareStatement(sql);
	    	Scanner sc=new Scanner(new File("C:/Users/heman/OneDrive/Desktop/SQL/newVIJAYAWADA.csv"));
	    	while(sc.hasNext())
	    	{
	    		String[] str = sc.nextLine().split(",");
	    		ps.setInt(1,Integer.parseInt(str[0]));
	    		ps.setString(2,str[1]);
	    		ps.setString(3,str[2]);
	    		ps.executeUpdate();
	    	}
	    	
	    }
	    
	    catch(Exception e){
	    	System.out.println(e);
	    }

		
		
		
		System.out.println("----------------------------");

		System.out.println(
				"| Select the destination : |\n| 1 for HYDERABAD          |\n| 2 for BANGLORE           |\n| 3 for VIZAG              |\n| 4 for CHENNAI            |\n| 5 for VIJAYAWADA         |");
		System.out.println("----------------------------");
		
		boolean w = true;

		while (w) {
			try {

				boolean h = true;
				while (h) {
					temp = in.nextInt();
					
					if (temp == 1 || temp == 2 || temp == 3 || temp == 4 || temp == 5) {
						System.out.println("ID           ITEM                                     PRICE");

						switch (temp) {
						case 1:
							String q1 = "select * from HYDmenu";
							Statement s1 = c1.createStatement();
							ResultSet r1 = s1.executeQuery(q1);
							while (r1.next()) {
								System.out.println(
										"--------------------------------------------------------------------");
								System.out.printf("%2d        %-28s         %12s\n", r1.getInt(1), r1.getString(2),
										r1.getString(3));
							}
							break;

						case 2:
							String q2 = "select * from BANGLOREmenu";
							Statement s2 = c1.createStatement();
							ResultSet r2 = s2.executeQuery(q2);
							while (r2.next()) {
								System.out.println(
										"--------------------------------------------------------------------");

								System.out.printf("%2d        %-28s         %12s\n", r2.getInt(1), r2.getString(2),
										r2.getString(3));
							}
							break;

						case 3:
							String q3 = "select * from VIZAGmenu";
							Statement s3 = c1.createStatement();
							ResultSet r3 = s3.executeQuery(q3);
							while (r3.next()) {
								System.out.println(
										"--------------------------------------------------------------------");

								System.out.printf("%2d        %-28s         %12s\n", r3.getInt(1), r3.getString(2),
										r3.getString(3));
							}
							break;

						case 4:
							String q4 = "select * from CHENNAImenu";
							Statement s4 = c1.createStatement();
							ResultSet r4 = s4.executeQuery(q4);
							while (r4.next()) {
								System.out.println(
										"--------------------------------------------------------------------");

								System.out.printf("%2d        %-28s         %12s\n", r4.getInt(1), r4.getString(2),
										r4.getString(3));
							}
							break;

						case 5:
							String q5 = "select * from VIJAYAWADAmenu";
							Statement s5 = c1.createStatement();
							ResultSet r5 = s5.executeQuery(q5);
							while (r5.next()) {
								System.out.println(
										"--------------------------------------------------------------------");
								System.out.printf("%2d        %-28s         %12s\n", r5.getInt(1), r5.getString(2),
										r5.getString(3));
							}
							break;

						}
						h = false;
					} else {
						System.out.println("Enter a valid input.");
						h = true;
					}
				}
				w = false;

			} catch (Exception e) {
				System.out.println("enter a valid input");
				in.next();
			}
		}
		System.out.println("--------------------------------------------------------------------");

		return temp;
	}

	
	public void SearchItems() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";
		Scanner in2 = new Scanner(System.in);
		Connection c1 = DriverManager.getConnection(url, uname, pass);
		
		
		System.out.println("----------------------------");

		System.out.println(
				"| Select the destination : |\n| 1 for HYDERABAD          |\n| 2 for BANGLORE           |\n| 3 for VIZAG              |\n| 4 for CHENNAI            |\n| 5 for VIJAYAWADA         |");
		System.out.println("----------------------------");
		
		int t = in.nextInt();
		
		System.out.println("Enter the item name : ");
		String test = in2.nextLine();
		
		String query = "";
		String query2 = "";

		switch (t) {

		case 1:
			query = "select * from HYDmenu where item LIKE '% " + test + "%' and price != '***'";
			query2 = "select * from HYDmenu where item LIKE '" + test + "%' and price != '***'";
			break;
		case 2:
			query = "select * from BANGLOREmenu where item LIKE '% " + test + "%' and price != '***'";
			query2 = "select * from BANGLOREmenu where item LIKE '" + test + "%' and price != '***'";
			break;
		case 3:
			query = "select * from Vizagmenu where item LIKE '% " + test + "%' and price != '***'";

			query2 = "select * from Vizagmenu where item LIKE '" + test + "%' and price != '***'";

			break;
		case 4:
			query = "select * from Chennaimenu where item LIKE '% " + test + "%' and price != '***'";

			query2 = "select * from Chennaimenu where item LIKE '" + test + "%' and price != '***'";

			break;
		case 5:
			query = "select * from Vijayawadamenu where item LIKE '% " + test + "%' and price != '***'";

			query2 = "select * from Vijayawadamenu where item LIKE '" + test + "%' and price != '***'";

			break;
		}

		PreparedStatement ps = c1.prepareStatement(query);
		ResultSet r1 = ps.executeQuery();

		PreparedStatement ps2 = c1.prepareStatement(query2);
		ResultSet r2 = ps2.executeQuery();

		while (r1.next()) {
			System.out.println("--------------------------------------------------------------------");
			System.out.printf("%2d        %-28s         %12s\n", r1.getInt(1), r1.getString(2), r1.getString(3));

		}

		while (r2.next()) {
			System.out.println("--------------------------------------------------------------------");
			System.out.printf("%2d        %-28s         %12s\n", r2.getInt(1), r2.getString(2), r2.getString(3));
		}
		System.out.println("--------------------------------------------------------------------");

	}
	
	public void SearchByPrice() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";
		Scanner in2 = new Scanner(System.in);
		Connection c1 = DriverManager.getConnection(url, uname, pass);
		
		System.out.println("----------------------------");

		System.out.println(
			"| Select the destination : |\n| 1 for HYDERABAD          |\n| 2 for BANGLORE           |\n| 3 for VIZAG              |\n| 4 for CHENNAI            |\n| 5 for VIJAYAWADA         |");
	System.out.println("----------------------------");
	
	int t = in.nextInt();

		System.out.println("Enter the price :");
		String p = in2.nextLine();
		String query = "";
		
		switch(t) {
		case 1:
			query = "select * from HYDmenu where price <= '"+p+"' and price != '***'";
			break;
			
		case 2:
			query = "select * from BANGLOREmenu where price <= '"+p+"' and price != '***'";
			break;
			
		case 3:
			query = "select * from VIZAGmenu where price <= '"+p+"' and price != '***'";
			break;
			
		case 4:
			query = "select * from CHENNAImenu where price <= '"+p+"' and price != '***'";
			break;
			
		case 5:
			query = "select * from VIJAYAWADAmenu where price <= '"+p+"' and price != '***'";
			break;
		}
		
		
		PreparedStatement ps = c1.prepareStatement(query);
		ResultSet r1 = ps.executeQuery();


		while (r1.next()) {
			System.out.println("--------------------------------------------------------------------");
			System.out.printf("%2d        %-28s         %12s\n", r1.getInt(1), r1.getString(2), r1.getString(3));

		}
		
		System.out.println("--------------------------------------------------------------------");

	}
	
	
	public void sum() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";
		Connection c1 = DriverManager.getConnection(url, uname, pass);
		
		String query = "";

		System.out.println("----------------------------");

		System.out.println(
			"| Select the destination : |\n| 1 for HYDERABAD          |\n| 2 for BANGLORE           |\n| 3 for VIZAG              |\n| 4 for CHENNAI            |\n| 5 for VIJAYAWADA         |");
	System.out.println("----------------------------");
	
	int t = in.nextInt();
		
		switch(t) {
		case 1:
			query = "select sum(price) from HYDmenu ";
			break;
			
		case 2:
			query = "select sum(price) from BANGLOREmenu ";
			break;
			
		case 3:
			query = "select sum(price) from VIZAGmenu ";
			break;
			
		case 4:
			query = "select sum(price) from CHENNAImenu ";
			break;
			
		case 5:
			query = "select sum(price) from VIJAYAWADAmenu ";
			break;
		}
		
		PreparedStatement ps = c1.prepareStatement(query);
		ResultSet r1 = ps.executeQuery();


		while (r1.next()) {
			System.out.printf("Total price off all the items is : %2d\n", r1.getInt(1));
		}
		
	}
	
	
	public void count() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";
		Connection c1 = DriverManager.getConnection(url, uname, pass);
		Scanner in = new Scanner(System.in);
		
		String query = "";
		
		System.out.println("----------------------------");
		System.out.println(
				"| Select the database :    |\n| 1 for Account            |\n| 2 for HYDERABAD          |\n| 3 for BANGLORE           |\n| 4 for VIZAG              |\n| 5 for CHENNAI            |\n| 6 for VIJAYAWADA         |");
		System.out.println("----------------------------");
		
		int k = in.nextInt();
		
		switch(k) {
		case 1:
			query = "select count(*) from Account ";
			break;
			
		case 2:
			query = "select count(*) from HYDmenu ";
			break;
			
		case 3:
			query = "select count(*) from BANGLOREmenu ";
			break;
			
		case 4:
			query = "select count(*) from VIZAGmenu ";
			break;
			
		case 5:
			query = "select count(*) from CHENNAImenu ";
			break;
			
		case 6:
			query = "select count(*) from VIJAYAWADAmenu ";
			break;
		}
		
		PreparedStatement ps = c1.prepareStatement(query);
		ResultSet r1 = ps.executeQuery();


		while (r1.next()) {
			System.out.printf("Count of all fields is: %2d\n", r1.getInt(1));
		}

	}
	
	
public void avg() throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";
		Connection c1 = DriverManager.getConnection(url, uname, pass);
		
		String query = "";

		System.out.println("----------------------------");

		System.out.println(
			"| Select the destination : |\n| 1 for HYDERABAD          |\n| 2 for BANGLORE           |\n| 3 for VIZAG              |\n| 4 for CHENNAI            |\n| 5 for VIJAYAWADA         |");
	System.out.println("----------------------------");
	
	int t = in.nextInt();
		
		switch(t) {
		case 1:
			query = "select avg(price) from HYDmenu ";
			break;
			
		case 2:
			query = "select avg(price) from BANGLOREmenu ";
			break;
			
		case 3:
			query = "select avg(price) from VIZAGmenu ";
			break;
			
		case 4:
			query = "select avg(price) from CHENNAImenu ";
			break;
			
		case 5:
			query = "select avg(price) from VIJAYAWADAmenu ";
			break;
		}
		
		PreparedStatement ps = c1.prepareStatement(query);
		ResultSet r1 = ps.executeQuery();


		while (r1.next()) {
			System.out.printf("Average price off all the items is : %2d\n", r1.getInt(1));
		}

}

}