
package Fachwerte;

import java.util.*;

/**
 * Stelle auf dem Spielbrett, welche durch Hoehen- und Breitenkoordinate beschrieben wird
 * 
 * @author steff
 *
 */
public class Stelle 
{
	private final int _hoehenKoordinate;
	private final int _breitenKoordinate;
	private static Map<String, Stelle> _stellen = new HashMap<String, Stelle>();
	
	private Stelle(int hoehe, int breite)
	{
		_hoehenKoordinate = hoehe;
		_breitenKoordinate = breite;
	}
	
	/**
	 * Fabrikmethode für Stellen
	 * 
	 * @param hoehe Die Hoehenkoordinate
	 * @param breite Die Breitenkoordinate
	 * @return Die entsprechende Stelle
	 */
	public static Stelle get(int hoehe, int breite)
	{
		if(!_stellen.containsKey(hoehe + "," + breite))
		{
			_stellen.put(hoehe + "," + breite , new Stelle(hoehe, breite));
		}
		
		return _stellen.get(hoehe + "," + breite);
	}
	
	/**
	 * Gibt Hoehenkoordinate der Stelle zurück
	 * 
	 * @return Die Hoehenkoordinate
	 */
	public int getHoehenKoordinate()
	{
		return _hoehenKoordinate;
	}
	
	/**
	 * Gibt die Breitenkoordinate der Stelle zurück
	 * 
	 * @return Die Breitenkoordinate
	 */
	public int getBreitenKoordinate()
	{
		return _breitenKoordinate;
	}
	
	/**
	 * Prüft ob ein übergebenes Objekt gleich zu der Stelle ist
	 * 
	 * @param Das zu vergleichende Objekt
	 */
	public boolean equals(Object o)
	{
		if(o instanceof Stelle)
		{
			Stelle stelle = (Stelle) o;
			return stelle.getBreitenKoordinate() == this.getBreitenKoordinate()
					&& stelle.getHoehenKoordinate() == this.getHoehenKoordinate();
		}
		return false;
	}
	
	/**
	 * Gibt den Hashcode zurück
	 */
	public int hashCode()
	{
		return 420 * 69 * _hoehenKoordinate + _breitenKoordinate;
	}
	
	/**
	 * Gibt die Stelle als String zurück
	 */
	public String toString()
	{
		return this._hoehenKoordinate + "," + this._breitenKoordinate;
	}
}
