package Services;


import Fachwerte.Stelle;
import Materialien.Spielbrett;

/**
 * Service zur Berechnung eines zu setzenden Steins
 * 
 * @author Steffen Schubert
 *
 */
public class SteinSetzerService 
{
	private Spielbrett _spielbrett;
	
	public SteinSetzerService(Spielbrett spielbrett)
	{
		_spielbrett = spielbrett;
	}

	/**
	 * Berechnet die Stelle die gesetzt werden soll in der �bergebenen Spalte
	 * 
	 * @param spalte Die Spalte in der die Stelle berechnet werden soll
	 * @return die Stelle
	 */
	public Stelle berechneStein(int spalte) 
	{
		int richtigeSpalte = spalte -1;
		int hoehe = berechneNiedrigsteHoehe(richtigeSpalte);
		return Stelle.get(hoehe, richtigeSpalte);
	}
	
	/**
	 * Setzt eine Stelle in die Map f�r rote Stellen auf dem Spielbrett
	 * 
	 * @param stelle die zu setzende Stelle
	 */
	public void setzeRot(Stelle stelle) 
	{
		_spielbrett.setRot(stelle);
	}

	/**
	 * Setzt eine Stelle in die Map f�r rote Stellen auf dem Spielbrett
	 * 
	 * @param stelle die zu setzende Stelle
	 */
	public void setzeBlau(Stelle stelle) 
	{
		_spielbrett.setBlau(stelle);
	}
	
	/**
	 * Gibt die niedrigste H�he zur�ck in der ein Stein gesetzt werden kann in der �bergebenen Spalte
	 * 
	 * @param spalte Die Spalte in der die Hoehe berechnet werden soll
	 * @return Die niedrigste m�gliche Hoehe
	 */
	private int berechneNiedrigsteHoehe(int spalte) 
	{
		int i = _spielbrett.getHoehe()-1;
		while(istStelleBesetzt(Stelle.get(i, spalte)))
		{
			i--;
		}
		return i;
	}
	
	/**
	 * Pr�ft ob eine Stelle bereits belegt ist
	 * 
	 * @param stelle die Stelle die �berpr�ft werden soll
	 * @return Ob die Stelle besetzt ist
	 */
	private boolean istStelleBesetzt(Stelle stelle)
	{
		return _spielbrett.getBlaue().containsKey(stelle.toString()) || _spielbrett.getRote().containsKey(stelle.toString()) ;
	}

}
