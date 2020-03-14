import java.util.Scanner;
class player{
	int noGuessed;
	String name ;
}
public class Guess_Game {

	public static void main(String[] args) {
		
		int guess = (int) ((Math.random() * 10)/2);
		
	Scanner m = new Scanner(System.in);
	System.out.print("Enter the no of payers: ");
	int players = m.nextInt();
	
	String[] Name = new String[players];
	int[] No = new int[players];

	int x = 0;
	 while (x < players) {
		 System.out.println();
		Scanner a = new Scanner(System.in);
		System.out.print("enter your name: ");
		Name[x] = a.nextLine();
		System.out.print("Guess a no between 0-4: ");
		No[x] = a.nextInt();
		x++;
	}
	 System.out.println();
	 boolean right  = false;
     for (int y = 0 ; y < players ; y++) {
    	 if (No[y] == guess) {
    		 System.out.println(Name[y]+" guessed it right");
    		 right = true;
    		 
    		
     }
	}
     if (right == false ) {
    	 System.out.println("Nobody Guessed it right");
     }
}
}
