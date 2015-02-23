public abstract class Kort implements Cloneable, Comparable<Kort> {
	protected String forNavn;
	protected String etterNavn;
	protected int pinKode;
	protected int kortNr;
	protected boolean sperretKort;
	private static int nesteLedigeKortNr = 100000;

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
		String datamedlemmer = String.format("%-30s%-20s%-20s%-20s%n", "Navn: "
				+ forNavn + " " + etterNavn, "PIN - kode: " + pinKode,
				"Kortnummer: " + kortNr, "Tilstand: "
						+ (isSperret() ? "Sperret" : "Åpen"));
		return datamedlemmer;
	}

	/**
	 * Metode for å få tilgang til pinkoden
	 * 
	 * @return pinkode
	 */
	protected int getPinKode() {
		return pinKode;
	}

	// Abstract methods
	/** Abstract metdoe som sjekker om pin Koden er rett */
	public abstract boolean sjekkPIN(int pin);

	/**
	 * CompareTo metode
	 * 
	 * @param k
	 *            Kortet som vårt kort skal sammenliknes med
	 * @return Dersom etternavnene er ulike returners enten et negativt eller positivt
	 *         heltall. Om det første etternavnet er alfabetisk ordnet før det
	 *         andre, returneres et negativt heltall. Et positivt heltall returneres i motsatt tilfelle. Dersom
	 *         etternavnene er like gjøres det samme på fornavnene.
	 *         Dersom også fornavnene er like returneres 0.
	 */
	@Override
	public int compareTo(Kort k) {
		if (this.etterNavn.compareTo(k.etterNavn) > 0) {
			return 1;
		} else if (this.etterNavn.compareTo(k.etterNavn) < 0) {
			return -1;
		} else if (this.forNavn.compareTo(k.forNavn) > 0) {
			return 1;
		} else if (this.forNavn.compareTo(k.forNavn) < 0) {
			return -1;
		} else
			return 0;
	}
	
	@Override /** Clone method som kloner kortet */
	public Object clone() {
		try {
		return super.clone();
		}
		catch (CloneNotSupportedException ex) {
			return null;
		}
	}
}
