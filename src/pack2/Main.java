package pack2;
import pack.*;
import java.util.*;
import java.io.File;
import java.sql.SQLException;

//import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception {
		
		if (args.length == 1 && args[0].equals("-h")) {
	           CommandLineArg commandLineArguments = new CommandLineArg();
	           System.out.println(commandLineArguments);
	           return;
	       }
			
			Account a = new Account();
			Menu m = new Cart();
			DeliveryBoy d = new DeliveryBoy();
			
	       if (args.length == 1 && args[0].equals("-create_acc")) {
	           a.create_account();
	       } else if (args.length == 1 && args[0].equals("-login")) {
	           a.login_account();
	       } else if (args.length == 1 && args[0].equals("-check")) {
	           a.checking();
	       } else if (args.length == 1 && args[0].equals("-getdet")) {
	           a.getdetails();
	       } else if (args.length == 1 && args[0].equals("-update")) {
	           a.Edit();
	       } else if (args.length == 1 && args[0].equals("-delete")) {
	           a.Delete();
	       } else if (args.length == 1 && args[0].equals("-menu")) {
	           m.SelectMenu();
	       } else if (args.length == 1 && args[0].equals("-selectItems")) {
	           ((Cart) m).AddToCart();
	           d.assignDeliveryBoy();
	       } else if (args.length == 1 && args[0].equals("-Dboy")) {
	       		d.assignDeliveryBoy();
	       } else if (args.length == 1 && args[0].equals("-searchByItem")) {
	   			m.SearchItems();
	       } else if (args.length == 1 && args[0].equals("-searchByPrice")) {
	   			m.SearchByPrice();
	       } else if (args.length == 1 && args[0].equals("-sum")) {
	   			m.sum();
	       } else if (args.length == 1 && args[0].equals("-avg")) {
					m.avg();
	    	  } else if (args.length == 1 && args[0].equals("-count")) {
	            m.count();
	    } 



	}

	}
	

