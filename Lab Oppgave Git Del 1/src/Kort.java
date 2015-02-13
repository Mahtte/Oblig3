public abstract class Kort {
	private String forNavn;
	private String etterNavn;
	private int pinKode;
	private int kortNr;
	private boolean sperretKort;
	private static int nesteLedigeKortNr = 000001;

	// Constructors
	/**
	 * Lager et nytt Kort
	 * 
	 * @param forNavn
	 *            brukerens fornavn
	 * @param etterNavn
	 *            brukerens etternavn
	 * @param pinKode
	 *            pinkode til kortet
	 */
	public Kort(String forNavn, String etterNavn, int pinKode) {
		this.forNavn = forNavn;
		this.etterNavn = etterNavn;
		this.pinKode = pinKode;
		kortNr = nesteLedigeKortNr;
		sperretKort = false;
		nesteLedigeKortNr++;
	}

	// Methods
	/**
	 * metode som returner navnet til brukeren av kortet
	 * 
	 * @return navnet til brukeren av kortet
	 */
	public String getNavn() {
		String navn = forNavn + " " + etterNavn;
		return navn;
	}

	/**
	 * Metode som returnerer true dersom kortet er sperret
	 * 
	 * @return true dersom kortet er sperret og false dersom kortet fortsatt kan
	 *         brukes
	 */
	public boolean isSperret() {
		return sperretKort;
	}

	/**
	 * Metode som skriver ut alle datamedlemmene i Kortet
	 * 
	 * @return String av alle datamedlemmene i Kortet
	 */
	@Override
	public String toString() {
		String datamedlemmer = String.format("%-20s%-20s%-20s%-20s%n", "Navn: "
				+ forNavn + " " + etterNavn, "PIN - kode: " + pinKode,
				"Kortnummer: " + kortNr, "Tilstand: "
						+ (isSperret() ? "Sperret" : "Åpen"));
		return datamedlemmer;
	}

	/**
	 * Metode for å få tilgang til koden
	 * 
	 * @return pinkode
	 */
	protected int getPinKode() {
		return pinKode;
	}

	// Abstract methods
	/** Abstract metdoe som sjekker om pin Koden er rett */
	public abstract boolean sjekkPIN(int pin);
}
