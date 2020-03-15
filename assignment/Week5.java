package assignment;

import java.util.Scanner;

public class Week5 {
	public static double calculateCharge(int TotalGuests) {
		final double  cost = 29.5;
		double charge =TotalGuests*cost;
	     if (TotalGuests >20 && TotalGuests <=40 ) {
	    	 charge =  (590 + ((TotalGuests-20)*24.5));
	     }else if (TotalGuests > 40) {
	    	 charge =  (1080 + ((TotalGuests -40)*19.5));
	     }
	     return charge;
	}

	public static void main(String[] args) {
	
		final int N = 3;    //enter greatest digit in your ID
		int totalGuests = 0;
		double totalCharge = 0;
     for (int m = 1;m <= N ;m++) {
			
		Scanner inText = new Scanner(System.in);
		Scanner inNumber = new Scanner(System.in);
		
		String customerName ;
		int NoOfGuests;
		System.out.print("Please enter customer name "+m+" => ");
	     customerName =	inText.nextLine();
	     System.out.print("Enter the number of guests for "+customerName+" => ");
	     NoOfGuests = inNumber.nextInt();
	     System.out.println();
	     
			System.out.println(" ---Receipt---");
         System.out.println("Customer name: "+customerName);
	     System.out.println("Number of guests for "+customerName+": "+NoOfGuests);
	     
	     System.out.println("Total charge: $"+calculateCharge(NoOfGuests));
	    System.out.println(); 
	    totalGuests += NoOfGuests;
	    totalCharge += calculateCharge(NoOfGuests);
		}
   float average = totalGuests*1.0f/N;
    System.out.println("The average number of Guests per customer is "+average);
    System.out.println("The total charges collected is "+totalCharge);

	}

}
