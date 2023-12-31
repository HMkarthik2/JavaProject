package pack;

public class CommandLineArg {
	    
public String toString(){
    	
    	String s = "";
    	
    	s += "-create_acc    : For creating a new account\n";
    	s += "-login         : To login to your account\n" ;
    	s += "-check         : To check if an account exists with your number\n";
    	s += "-getdet        : To get your account details\n";
    	s += "-update        : To update your account details\n";
    	s += "-delete        : To permanently delete your account\n";
    	s += "-menu          : To select menu of your location\n";
    	s += "-selectItems   : To select items from menu\n";
    	s += "-searchByItem  : To search items in the menu by item name (Supports partial string searching)\n";
    	s += "-searchByPrice : To search items in the menu by item price (Gives items whose cost is less than mentioned price\n";
		s += "-Dboy          : To assign a delivery boy\n";
    	s += "-count         : To count number of rows in the database\n";
    	s += "-sum           : To find sum of prices of all items in the menu\n";
    	s += "-avg           : To find average of prices of all items in the menu\n";
    	
    	return s;
    }      
	
	
	
}
