import java.util.*;

public class Ansatt extends Kort {
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

	/**
	 * Metode som sjekker om den ansatte må taste inn
	 * pin kode, og om den i så fall er gyldig og om kortet er sperret
	 * 
	 * @param kode
	 *            koden som skal sjekkes
	 */
	public boolean sjekkPIN(int kode) {
		if (!skalPinTastes() && !isSperret()) {
			return true;
		}
		else {
			if (kode == this.getPinKode() && !isSperret()) {
				return true;
			}
			else return false;
		} 
	}
	
	/** Privat boolean metode som returner true dersom den ansatte må taste inn pin koden. Den ansatte 
	 * må taste pinkoden dersom hun prøver å komme inn utenfor kontortiden, som er fra 07 til 17 alle hverdager
	 * @return true dersom pin koden skal tastes og false dersom den ikke skal tastes
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

		if (sjekkTidsPunkt.compareTo(ikkePIN) >= 0
				&& sjekkTidsPunkt.compareTo(ikkePIN2) <= 0
				&& sjekkTidsPunkt.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
				&& sjekkTidsPunkt.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			return true;
		} else return false;

	}
}
