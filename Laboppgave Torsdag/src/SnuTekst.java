import java.util.Scanner;

public class SnuTekst {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv inn en tekststreng: ");
		String tekst = input.nextLine();
		System.out.println(tekst + " baklengs blir: ");
		baklengs(tekst);
		input.close();
	}
	
	public static void baklengs(String tekst) {
		if (tekst.length() <= 1)		// Base case
			System.out.print(tekst.charAt(tekst.length() - 1));
		else {
			System.out.print(tekst.charAt(tekst.length() - 1));
			baklengs(tekst.substring(0, tekst.length() - 1));
		}
	}
}
