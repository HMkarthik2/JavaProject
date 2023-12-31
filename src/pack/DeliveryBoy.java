package pack;
import java.util.*;

import pack2.Cart;

import java.sql.*;
import java.security.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DeliveryBoy extends Cart implements ProjInterface {
public void assignDeliveryBoy() throws SQLException,ClassNotFoundException {
		
		String url = "jdbc:mysql://localhost:3306/OOPproject";
		String uname = "root";
		String pass = "hemanthmysql";
		
		Connection c1 = DriverManager.getConnection(url, uname, pass);
		Statement st = c1.createStatement();
		
		
		try {
			String query="CREATE TABLE IF NOT EXISTS  delivery_boy(\r\n"
			  		+ "sno int NOT NULL,\r\n"
			  		+ " name varchar(30) NOT NULL,\r\n"
			  		+ " ph_no numeric(10) PRIMARY KEY NOT NULL\r\n"
			  		+ ");";
			     PreparedStatement ps = c1.prepareStatement(query);
			 	 int n =ps.executeUpdate();

		}
		  catch(Exception e) {
			  System.out.println("Error");
		  }
		
		try {
	    	String sql ="insert into delivery_boy values(?,?,?)";
	    	
	    	PreparedStatement ps=c1.prepareStatement(sql);
	    	Scanner sc=new Scanner(new File("C:/Users/heman/OneDrive/Desktop/SQL/Dboy.csv"));
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
		
		
		SecureRandom rand = new SecureRandom();
		int k = rand.nextInt(6) + 1;
		String query = "select name,ph_no from delivery_boy where sno = '"+ k +"' ";
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Name : " +rs.getString(1)+ " Phone number : " +rs.getString(2));
		}
		System.out.println("Your order will be delivered soon");
	
		c1.close();
	}
	
	@Override
	public void PrintMessage() {
		System.out.println("You are currently viewing Delivery Boy.");
	}
	
	@Override
	public void Rating() {
		Scanner in = new Scanner(System.in);
		
		boolean r = true;
		while(r) {
			try {
				boolean y = true;
				while(y) {
			System.out.println("Please rate our service (1 to 5): ");
			int t = in.nextInt();
			if(t<1 || t>5) {
				System.out.println("Enter a valid input");
			}
			else {
				y=false;
			}
				}
			r = false;
			}
			catch(Exception e) {
				System.out.println("Enter a valid input");
				in.next();
			}
		}
		
		System.out.println("Thank you for the valuable feedback");
		
	}
}
