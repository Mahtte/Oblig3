
public abstract class Kort {
	private String forNavn;
	private String etterNavn;
	private int pinKode;
	private int kortNr;
	private boolean sperretKort;
	private static int nesteLedigeKortNr = 000001;
	
	// Constructors
	/** Lager et nytt Kort
	 * 
	 * @param forNavn brukerens fornavn
	 * @param etterNavn	brukerens etternavn
	 * @param pinKode pinkode til kortet
	 */
	public Kort(String forNavn, String etterNavn, int pinKode) {
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.pinKode = pinKode;
		kortNr = nesteLedigeKortNr;
		sperretKort = false;
		nesteLedigeKortNr ++;
	}
	
	// Methods
	/** metode som returner navnet til brukeren av kortet
	 * 
	 * @return navnet til brukeren av kortet
	 */
	public String getNavn() {
		String navn = forNavn + " " + etterNavn;
		return navn;
	}
	
	
	
	
}

