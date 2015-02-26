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
	
	static int antallTegn = 0;
	
	public static void baklengs(String tekst) {
		baklengs(tekst, tekst.length() - 1);
	      System.out.printf("%nAntall tegn: " + antallTegn);
	}
	
	public static void baklengs(String tekst, int siste) {
	    if (siste >= 0) {
	      System.out.print(tekst.charAt(siste));
			antallTegn++;
	      baklengs(tekst, siste - 1);
	    }
	  }
}
