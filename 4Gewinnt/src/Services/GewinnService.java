package Services;

import Fachwerte.Stelle;
import Materialien.Spielbrett;

/**
 * Service zur �berpr�fung auf einen Gewinner 
 * 
 * @author Steffen Schubert
 *
 */
public class GewinnService 
{
	private Spielbrett _spielbrett;
	
	public GewinnService(Spielbrett spielbrett)
	{
		_spielbrett = spielbrett;
	}
	
	/**
	 * Pr�ft ob mit der �bergebenen Stelle jemand gewonnen hat.
	 * 
	 * @param stelle Die zu pr�fende Stelle
	 * @return Ob jemand gewonnen hat
	 */
	public boolean pruefeAufGewinner(Stelle stelle)
	{
		int farbe = _spielbrett.getFarbe(stelle);
		return pruefeHorizontal(stelle, farbe) || pruefeVertikal(stelle, farbe) || pruefeDiagonal(stelle, farbe) ;
	}

	/**
	 * Pr�ft ob horizontal zu der �bergebenen Stelle 3 Gleichfarbige Nachbarn vorhanden sind
	 *  
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die farbe der Stelle
	 * @return Ob 3 oder mehr Nachbarn die gleiche Farbe haben
	 */
	private boolean pruefeHorizontal(Stelle stelle, int farbe) 
	{
		return pruefeLinks(Stelle.get(stelle.getHoehenKoordinate(), stelle.getBreitenKoordinate()-1), farbe) + pruefeRechts(Stelle.get(stelle.getHoehenKoordinate(), stelle.getBreitenKoordinate()+1), farbe) >= 3;
	}

	/**
	 * Z�hlt gleichfarbige Nachbarn nach rechts
	 * 
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die Farbe der zu pr�fenden Stelle
	 * @return Anzahl der Nachbarn nach rechts
	 */
	private int pruefeRechts(Stelle stelle , int  farbe )
	{
		if(_spielbrett.getFarbe(stelle) != farbe)
		{
			return 0;
		}
		else
		{
			return 1 + pruefeRechts(Stelle.get(stelle.getHoehenKoordinate(), stelle.getBreitenKoordinate()+1), farbe);
		}
	}

	/**
	 * Z�hlt gleichfarbige Nachbarn nach links
	 * 
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die Farbe der zu pr�fenden Stelle
	 * @return Anzahl der Nachbarn nach links
	 */
	private int pruefeLinks(Stelle stelle, int farbe) 
	{
		if( _spielbrett.getFarbe(stelle) != farbe )
		{
			return 0;
		}
		else
		{
			return 1 + pruefeLinks(Stelle.get(stelle.getHoehenKoordinate(), stelle.getBreitenKoordinate()-1), farbe);
		}
	}

	/**
	 * Pr�ft ob vertikal zu der �bergebenen Stelle 3 Gleichfarbige Nachbarn vorhanden sind
	 *  
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die farbe der Stelle
	 * @return Ob 3 oder mehr Nachbarn die gleiche Farbe haben
	 */
	private boolean pruefeVertikal(Stelle stelle, int farbe) 
	{
		return pruefeUnten(Stelle.get(stelle.getHoehenKoordinate()+1, stelle.getBreitenKoordinate()), farbe) >= 3;
	}

	/**
	 * Z�hlt gleichfarbige Nachbarn nach unten
	 * 
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die Farbe der zu pr�fenden Stelle
	 * @return Anzahl der Nachbarn nach unten
	 */
	private int pruefeUnten(Stelle stelle, int farbe) 
	{
		if( _spielbrett.getFarbe(stelle) != farbe )
		{
			return 0;
		}
		else
		{
			return 1 + pruefeUnten(Stelle.get(stelle.getHoehenKoordinate()+1, stelle.getBreitenKoordinate()), farbe);
		}
	}
	
	/**
	 * Pr�ft ob diagonal jemand gewonnen hat
	 *  
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die farbe der Stelle
	 * @return Ob diagonal jemand gewonnen hat
	 */
	private boolean pruefeDiagonal(Stelle stelle, int farbe) 
	{
		return diagonalRechts(stelle, farbe) || diagonalLinks(stelle, farbe);
	}

	/**
	 * Pr�ft ob diagonal nach rechts zu der �bergebenen Stelle 3 Gleichfarbige Nachbarn vorhanden sind
	 *  
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die farbe der Stelle
	 * @return Ob 3 oder mehr Nachbarn die gleiche Farbe haben
	 */
	private boolean diagonalRechts(Stelle stelle, int farbe) 
	{
		return pruefeUntenLinks(Stelle.get(stelle.getHoehenKoordinate()+1, stelle.getBreitenKoordinate()-1), farbe) + pruefeObenRechts(Stelle.get(stelle.getHoehenKoordinate()-1, stelle.getBreitenKoordinate()+1), farbe) >= 3;
	}

	/**
	 * Pr�ft ob diagonal nach links zu der �bergebenen Stelle 3 Gleichfarbige Nachbarn vorhanden sind
	 *  
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die farbe der Stelle
	 * @return Ob 3 oder mehr Nachbarn die gleiche Farbe haben
	 */
	private boolean diagonalLinks(Stelle stelle, int farbe) 
	{
		return pruefeObenLinks(Stelle.get(stelle.getHoehenKoordinate()-1, stelle.getBreitenKoordinate()-1), farbe) + pruefeUntenRechts(Stelle.get(stelle.getHoehenKoordinate()+1, stelle.getBreitenKoordinate()+1), farbe) >= 3;
	}
	
	/**
	 * Z�hlt gleichfarbige Nachbarn nach untenrechts
	 * 
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die Farbe der zu pr�fenden Stelle
	 * @return Anzahl der Nachbarn nach untenrechts 
	 */
	private int pruefeUntenRechts(Stelle stelle, int farbe) {
		if( _spielbrett.getFarbe(stelle) != farbe )
		{
			return 0;
		}
		else
		{
			return 1 + pruefeUntenRechts(Stelle.get(stelle.getHoehenKoordinate()+1, stelle.getBreitenKoordinate()+1), farbe);
		}
	}

	/**
	 * Z�hlt gleichfarbige Nachbarn nach obenlinks
	 * 
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die Farbe der zu pr�fenden Stelle
	 * @return Anzahl der Nachbarn nach obenlinks  
	 */
	private int pruefeObenLinks(Stelle stelle, int farbe) 
	{
		if( _spielbrett.getFarbe(stelle) != farbe )
		{
			return 0;
		}
		else
		{
			return 1 + pruefeObenLinks(Stelle.get(stelle.getHoehenKoordinate()-1, stelle.getBreitenKoordinate()-1), farbe);
		}
	}

	/**
	 * Z�hlt gleichfarbige Nachbarn nach obenrechts
	 * 
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die Farbe der zu pr�fenden Stelle
	 * @return Anzahl der Nachbarn nach obenrechts 
	 */
	private int pruefeObenRechts(Stelle stelle , int  farbe )
	{
		if( _spielbrett.getFarbe(stelle) != farbe )
		{
			return 0;
		}
		else
		{
			return 1 + pruefeObenRechts(Stelle.get(stelle.getHoehenKoordinate()-1, stelle.getBreitenKoordinate()+1), farbe);
		}
	}

	/**
	 * Z�hlt gleichfarbige Nachbarn nach untenlinks
	 * 
	 * @param stelle Die zu pr�fende Stelle
	 * @param farbe Die Farbe der zu pr�fenden Stelle
	 * @return Anzahl der Nachbarn nach untenlinks 
	 */
	private int pruefeUntenLinks(Stelle stelle, int farbe) 
	{
		if( _spielbrett.getFarbe(stelle) != farbe )
		{
			return 0;
		}
		else
		{
			return 1 + pruefeUntenLinks(Stelle.get(stelle.getHoehenKoordinate()+1, stelle.getBreitenKoordinate()-1), farbe);
		}
	}

}
