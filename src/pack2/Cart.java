package pack2;
import pack.*;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.*;

import pack.ProjInterface;

public class Cart extends Menu implements ProjInterface  {

	ArrayList<Integer> items = new ArrayList<Integer>();
	ArrayList<Integer> quantity = new ArrayList<Integer>();
	Scanner in = new Scanner(System.in);
	int t,q,ch;

	boolean r=true;
	
	@Override
	public  void PrintMessage() {
		System.out.println("You are currently viewing cart");
	}
	
	
	
public void AddToCart() throws SQLException, FileNotFoundException {
	 
	        t = this.SelectMenu();
			int c = 0;
			boolean r =true;
			while(r){	
			try {  
				boolean e=true;
				while(e) {
			System.out.println("Enter ID of item to select/ Else enter -1.");
			    c = in.nextInt();
			    if((c >75 || c <1) && c!=-1) {
			    	System.out.println("*** ID should be between 1 and  75 ***");
			    }
			    else {
			    	e=false;
			    }
				}

			    r=false;    
			}
			catch(InputMismatchException e){
				System.out.println("*** ID should be integer  ***");
				in.next();
			}                             }
				
			r=true;
			while(c != -1) {
				items.add(c);
				while(r) {
					System.out.println("Enter the quantity.");
					try {
						 q = in.nextInt();
						 if(q>0){
								quantity.add(q);
								r=false;
								}
								else{
									System.out.println("Quantity should be greater than 0");
									r=true;
								}
						 }
						catch(InputMismatchException e){
							System.out.println("*** quantity should be an integer  ***");
							in.next();
						}
				}
				r=true;
				// boolean f = true;
				while(r){	
					try {
						boolean e=true;
				while(e) {
			System.out.println("Enter ID of item to select/ Else enter -1.");
			    c = in.nextInt();
			    if((c >75 || c <1 )&&c!=-1) {
			    	System.out.println("*** ID should be between 1 and  75 ***");
			    }
			    else {
			    	e=false;
			    }
				}
					    r=false;    
					}
					catch(InputMismatchException e){
						System.out.println("*** ID should be integer  ***");
						in.next();
					}
					}
				r=true;
			}
			
			this.BILL();
			System.out.println("Enter 1 to alter your bill , Else enter -1");
            int ch=in.nextInt();
			if(ch==1){
			this.Alter();
			this.BILL();}

   }

public void BILL() throws SQLException {
        int count=0;
	    int total=0;
	     String url="jdbc:mysql://localhost:3306/OOPproject";
	     String username="root";
	     String password="hemanthmysql";
	     Connection con=DriverManager.getConnection(url,username,password);
	 
		SortItems(items,quantity);

			System.out.println("     ********** BILL **********     ");
			System.out.println("--------------------------------------------------------------------");
			System.out.printf("| ID %-6s Item %16s quantity %6s price %5s total|\n","","","","");
			System.out.println("--------------------------------------------------------------------");
			String query = "";
			for(int i=0;i<items.size();i++) {
				switch(t) {
				case 1:
				    query="select * from hydmenu WHERE Id = " + items.get(i) ;
				    break;
				case 2:
				    query="select * from BANGLOREmenu  WHERE Id = " + items.get(i) ;
				    break;
				case 3:
				    query="select * from vizagmenu WHERE Id = " + items.get(i) ;
				    break;
				case 4: 
				    query="select * from chennaimenu WHERE Id = " + items.get(i) ;
				    break;
				case 5:
				    query="select * from vijayawadamenu WHERE Id = " +items.get(i) ;
				    break;}
				 Statement st=con.createStatement();
				 ResultSet rs =st.executeQuery(query);
		    	 rs.next();
		    	 if(quantity.get(i)!=0) {
		    	 System.out.printf("\n %2d      %-25s   x %2d   %11s  %8d\n",rs.getInt(1),rs.getString(2),quantity.get(i),rs.getString(3),quantity.get(i)*Integer.parseInt(rs.getString(3)));
		    	 count++;}
		    	 total+=quantity.get(i)*Integer.parseInt(rs.getString(3));
		    	 
		    	 }
			
			    System.out.println("--------------------------------------------------------------------");
			    System.out.printf("%2d      %-25s       %25s\n",count,"",total);  
			    
}


		public void SortItems(ArrayList<Integer> a , ArrayList<Integer> q) {
			for(int j=0; j<a.size(); j++) {
				int min = j;
				for(int k=j+1;k<a.size();k++) {
					if(a.get(min) > a.get(k)) {	
						min = k;
					}
				}
				int temp= a.get(min);
				a.set(min, a.get(j));
				a.set(j, temp);
				
				temp= q.get(min);
				q.set(min, q.get(j));
				q.set(j, temp);
			}
		}

		
		
	public void Alter() throws SQLException{
		
		boolean r = true;
		
		int f = 0;
	
			int v=0;
			while(f != -1) {
				try {
					System.out.println("Enter ID of the item you want to alter /Else enter -1 ");
					v =in.nextInt();

					 int c1 = 0;
					 for(int i=0;i<items.size();i++) {
						 if(items.get(i)==v) {
								 r=true;
								 while(r) {
									 try {
								 System.out.println("Enter new quantity of the item/Enter 0 to delete that item");
								 int k=in.nextInt();
								 if(k==0) {
									 items.remove(i);
									 quantity.remove(i);
								 }
								 else {
								 quantity.add(i, k);
								 }
								   r=false;
								   c1 = 1;
									 }
									 catch(InputMismatchException e){
										 System.out.println("*** Enter valid input ***");
											in.next();
									   }
								 }
						 }
	
					 }
					 if(c1 != 1)
						 System.out.println("Item not present in cart");
					 
					 
					 
				}
				catch(Exception e) {
					System.out.println("Enter a valid input");
					in.next();
				}
				System.out.println("Enter 1 to alter other items/ else -1:");
				 boolean t =true;
				 
				 while(t) {
					 try {
						 f = in.nextInt();
						 t = false;
					 }
					 catch(Exception e) {
						 System.out.println("*** Enter valid input ***");
							in.next();
					 }
				 }
			}
	
			
			}

	
}