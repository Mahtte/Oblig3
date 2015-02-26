import java.util.Scanner;

public class TowersOfHanoi {
	/** Main method */
	public static void main(String[] args) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Angi antall disker: ");
		int n = input.nextInt();
		// Find the solution recursively
		System.out.println("Slik flyttes diskene:");
		moveDisks(n, 'A', 'B', 'C');
		antallKall++;
		System.out.println("Diskene ble flyttet " + antallFlyttinger + " ganger");
		System.out.println("Antall kall til den rekursive metoden: " + antallKall);
	}
	
	  static int antallFlyttinger = 0; //holder rede på antall flyttinger
	  static int antallKall = 0;	// Holder rede på antall kall til den rekursive metoden
	  
	/**
	 * The method for finding the solution to move n disks from fromTower to
	 * toTower with auxTower
	 */
	public static void moveDisks(int n, char fromTower, char toTower,
			char auxTower) {
		antallFlyttinger++;
		if (n == 1) // Stopping condition
			System.out.println("Flytt disk " + n + " fra " + fromTower + " til "
					+ toTower);
		else {
			moveDisks(n - 1, fromTower, auxTower, toTower);
			antallKall++;
			System.out.println("Flytt disk " + n + " fra " + fromTower + " til "
					+ toTower);
			moveDisks(n - 1, auxTower, toTower, fromTower);
			antallKall++;
		}
	}
}