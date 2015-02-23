import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gjest extends Kort {
	private GregorianCalendar kortGyldigTil;

	// Constructors
	/**
	 * Opprettet et nytt kort for en gjest
	 * 
	 * @param forNavn
	 *            fornavnet til brukeren
	 * @param etterNavn
	 *            etternavnet til brukeren
	 */
	public Gjest(String forNavn, String etterNavn) {
		super(forNavn, etterNavn, 9999);
		kortGyldigTil = new GregorianCalendar();
		kortGyldigTil.set(Calendar.DAY_OF_MONTH,
				kortGyldigTil.get(Calendar.DAY_OF_MONTH) + 7);
	}
	
	//Methods
	/**
	 * Metode som sjekker om Pin koden er gyldig, om kortet fortsatt er gyldig
	 * og om kortet er sperret
	 * 
	 * @param kode
	 *            koden som skal sjekkes
	 */
	public boolean sjekkPIN(int kode) {
		GregorianCalendar sjekkTidsPunkt = new GregorianCalendar();
		if (kode == this.getPinKode()
				&& sjekkTidsPunkt.compareTo(kortGyldigTil) <= 0 && !isSperret()) {
			return true;
		} else
			return false;
	}

}
