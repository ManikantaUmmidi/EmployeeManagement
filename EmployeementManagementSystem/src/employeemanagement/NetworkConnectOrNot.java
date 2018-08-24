package employeemanagement;

import java.net.URL;
import java.net.URLConnection;

public class NetworkConnectOrNot {
	
	public static boolean isNetworkAvailble()
	{
		try 
		{
		        URL url = new URL("http://www.google.com");
		 
		        URLConnection connection = url.openConnection();
		        connection.connect();   
		 
		        System.out.println("Internet Connected");  
		        return true;
		            
		 }catch (Exception e){
		     
		System.out.println("Sorry, No Internet Connection");     
		
		  return false;
		
       		} 

	}

}
