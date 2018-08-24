package employeemanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class tes {
	
	 public static void main(String args[])
	    {
		/* Calendar cal = Calendar.getInstance();
		 System.out.println(new SimpleDateFormat("MMM").format(cal.getTime()));
		 
		 */
		 
		 
		/* SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		 String inputString1 = "2018-08-10";
		 String inputString2 = "2018-08-12";
        
		 try {
		     Date date1 = myFormat.parse(inputString1);
		     Date date2 = myFormat.parse(inputString2);
		     long diff = date2.getTime() - date1.getTime();
		     System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		 } catch (ParseException e) {
		     e.printStackTrace();
		 }*/
		 
	/*	 java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    System.out.println("utilDate:" + utilDate);
		    System.out.println("sqlDate:" + sqlDate);
		 
	    }*/
/*
		 Calendar cal = Calendar.getInstance();
		 System.out.println(new SimpleDateFormat("yyyy").format(cal.getTime()));
}*/
		 
		 
		/* long timeNow = Calendar.getInstance().getTimeInMillis();
		 java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);
		
		 preparedStatement.setTimestamp(TIME_COL_INDEX, ts);*/

	    
		  long timeNow = Calendar.getInstance().getTimeInMillis();
		 java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);
		 System.out.println(ts);

	    }
}