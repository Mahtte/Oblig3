
public interface Fast {
	final double FAKTOR_KREDITT = 1.25;
	final double FAKTOR_BONUS = 1.25;
	
	public abstract void settForNavn(String forNavn);
	public abstract String hentForNavn();
	public abstract void settEtterNavn(String etterNavn);
	public abstract String hentEtterNavn();
	public abstract void settFulltNavn(String fulltNavn);
	public abstract String hentFulltNavn();
	public abstract double beregnKreditt();
	public abstract double beregnBonus();
}
