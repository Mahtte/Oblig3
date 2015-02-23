import java.util.*;

public class Ansatt extends Kort implements Fast {
	private double timelønn;
	private int ansinitet;
	// Constructor
	/**
	 * Oppretter et nytt ansatt kort
	 * 
	 * @param forNavn
	 *            Fornavnet til brukeren
	 * @param etterNavn
	 *            Etternavnet til brukeren
	 * @param pinKode
	 *            valgt pingkode
	 */
	public Ansatt(String forNavn, String etterNavn, int pinKode) {
		super(forNavn, etterNavn, pinKode);
	}
	
	/** oppretter et nytt ansatt kort
	 * 
	 * @param forNavn
	 * @param etterNavn
	 * @param pinKode
	 * @param timelønn
	 * @param ansinitet
	 */
	public Ansatt(String forNavn, String etterNavn, int pinKode, double timelønn, int ansinitet) {
		super(forNavn, etterNavn, pinKode);
		this.timelønn = timelønn;
		this.ansinitet = ansinitet;
	}
	
	//Methods
	/**
	 * Metode som sjekker om pin koden er gyldig
	 * 
	 * @param kode
	 *            koden som skal sjekkes
	 * @return true dersom pinkoden er gyldig, false dersom den er ugyldig
	 */
	public boolean sjekkPIN(int kode) {
		if (kode == this.getPinKode() && !isSperret()) {
			return true;
		} else if (!isSperret() && !skalPinTastes()) {
			return true;
		} else
			return false;
	}

	/**
	 * boolean metode som returner true dersom den ansatte må taste inn pin
	 * koden. Den ansatte må taste pinkoden dersom hun/han prøver å komme inn
	 * utenfor kontortiden, som er fra 07 til 17 alle hverdager
	 * 
	 * @return true dersom pin koden skal tastes og false dersom den ikke skal
	 *         tastes
	 */
	private boolean skalPinTastes() {
		GregorianCalendar sjekkTidsPunkt = new GregorianCalendar();
		GregorianCalendar ikkePIN = new GregorianCalendar(
				sjekkTidsPunkt.get(Calendar.YEAR),
				sjekkTidsPunkt.get(Calendar.MONTH),
				sjekkTidsPunkt.get(Calendar.DAY_OF_MONTH), 7, 0, 0);
		GregorianCalendar ikkePIN2 = new GregorianCalendar(
				sjekkTidsPunkt.get(Calendar.YEAR),
				sjekkTidsPunkt.get(Calendar.MONTH),
				sjekkTidsPunkt.get(Calendar.DAY_OF_MONTH), 17, 0, 0);

		if (sjekkTidsPunkt.compareTo(ikkePIN) > 0
				|| sjekkTidsPunkt.compareTo(ikkePIN2) < 0
				|| sjekkTidsPunkt.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| sjekkTidsPunkt.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return true;
		} else
			return false;

	}
	
	/** Set metode for fornavn
	 * 
	 * @param forNavn
	 */
	public void settForNavn(String forNavn) {
		this.forNavn = forNavn;
	}
	
	/** Get metode for fornavn
	 * @return fornavn
	 */
	public String hentForNavn() {
		return this.forNavn;
	}
	
	/** set metode for etternavn
	 * @param etterNavn etternavnet 
	 */
	public void settEtterNavn(String etterNavn) {
		this.etterNavn = etterNavn;
	}
	
	/** Get metode for etternavn
	 * @return etternavn
	 */
	public String hentEtterNavn() {
		return this.etterNavn;
	}
	
	/** Set metode for fullt navn
	 * @param fulltNavn hele navnet. Adskilt med mellomrom
	 */
	public void settFulltNavn(String fulltNavn) {
		String forNavnOgEtterNavn = fulltNavn;
		String[] navn = forNavnOgEtterNavn.split(" ");
		this.etterNavn = navn[navn.length - 1];	
		if (navn.length > 2) {
			this.forNavn = navn[0];
			for (int i = 1; i < navn.length - 1; i++) {
				this.forNavn = this.forNavn.concat(" " + navn[i]);
			}

		} else {
			this.forNavn = navn[0];
		}

	}
	
	/** Get metode for fullt navn
	 * 
	 * @return fornavn + etternavn
	 */
	public String hentFulltNavn() {
		return (this.forNavn + " " + this.etterNavn);
	}
	
	/** metode som beregner kreditt
	 * @return timelønn ganger faktor kreditt
	 */
	public double beregnKreditt() {
		return Fast.FAKTOR_KREDITT * timelønn;
	}
	
	/** Metode som beregner bonus
	 * @return bonus = antall års ansinitet ganger faktor
	 */
	public double beregnBonus() {
		return Fast.FAKTOR_BONUS * ansinitet;
	}
}
