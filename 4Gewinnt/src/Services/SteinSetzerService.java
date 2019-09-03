package Services;


import Fachwerte.Stelle;
import Materialien.Spielbrett;

/**
 * Service zur Berechnung eines zu setzenden Steins
 * 
 * @author steff
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
	 * Berechnet die Stelle die gesetzt werden soll in der übergebenen Spalte
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
	 * Setzt eine Stelle in die Map für rote Stellen auf dem Spielbrett
	 * 
	 * @param stelle die zu setzende Stelle
	 */
	public void setzeRot(Stelle stelle) 
	{
		_spielbrett.getRote().put(stelle.toString(), stelle);
	}

	/**
	 * Setzt eine Stelle in die Map für rote Stellen auf dem Spielbrett
	 * 
	 * @param stelle die zu setzende Stelle
	 */
	public void setzeBlau(Stelle stelle) 
	{
		_spielbrett.getBlaue().put(stelle.toString(), stelle);
	}
	
	/**
	 * Gibt die niedrigste Höhe zurück in der ein Stein gesetzt werden kann in der übergebenen Spalte
	 * 
	 * @param spalte Die Spalte in der die Hoehe berechnet werden soll
	 * @return Die niedrigste mögliche Hoehe
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
	 * Prüft ob eine Stelle bereits belegt ist
	 * 
	 * @param stelle die Stelle die überprüft werden soll
	 * @return Ob die Stelle besetzt ist
	 */
	private boolean istStelleBesetzt(Stelle stelle)
	{
		return _spielbrett.getBlaue().containsKey(stelle.toString()) || _spielbrett.getRote().containsKey(stelle.toString()) ;
	}

}
