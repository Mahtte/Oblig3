
public class SnuTekst {
	
	public static void main(String[] args) {
		baklengs("hei");
	}
	
	public static void baklengs(String tekst) {
		if (tekst.length() <= 1)		// Base case
			System.out.print(tekst.charAt(tekst.length() - 1));
		else 
			baklengs(tekst.substring(0, tekst.length() - 1));
	}
}
