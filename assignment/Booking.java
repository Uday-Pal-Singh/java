package assignment;

public class Booking {
private String customerName;
private int guests;

public Booking (){
	
}

public Booking(String customerName, int guests) {
	super();
	this.customerName = customerName;
	this.guests = guests;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public int getGuests() {
	return guests;
}

public void setGuests(int guests) {
	this.guests = guests;
}

public double calculateCharge() {
     int x = this.guests; // stores the no of guests in the variable x
     final double charge = 29.5;
     double Total_Charge = 0;
     
     if (x <= 20) {
    	 Total_Charge = charge * x;
     }else if (x > 20 && x <= 40) {
    	 Total_Charge = ((charge - 5) * (x - 20)) + (20 * charge) ;
     }else {
    	 Total_Charge = ((charge - 10) * (x - 40)) + (20 * charge) +(20 * (charge - 5));
     }
     
     return Total_Charge;
}

}
