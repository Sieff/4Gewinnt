
package Materialien;

import java.util.*;

import Fachwerte.Stelle;

/**
 * Ein Spielbrett, dass aus einem Doppelarray aus Stellen besteht
 * 
 * @author steff
 *
 */
public class Spielbrett 
{
	private int _hoehe;
	private int _breite;
	private Stelle[][] _plan;

	private Map<String, Stelle> _roteStellen;
	private Map<String, Stelle> _blaueStellen;
	
	public Spielbrett(int hoehe, int breite)
	{
		_hoehe = hoehe;
		_breite = breite;
		_plan = new Stelle[_hoehe][_breite];
		
		_roteStellen = new HashMap<String, Stelle>();
		_blaueStellen = new HashMap<String, Stelle>();
		
		for(int i = 1; i < _hoehe ; i++)
		{
			for(int j = 1; j < _breite; j++)
			{
				_plan[i][j] = Stelle.get(i, j);
			}
		}
	}
	
	/**
	 * Setzt eine Übergebene Stelle auf dem Spielbrett rot
	 * 
	 * @param stelle Die zu färbende Stelle
	 */
	public void setRot(Stelle stelle)
	{
		_roteStellen.put(stelle.toString(), stelle);
	}
	
	/**
	 * Setzt eine Übergebene Stelle auf dem Spielbrett blau
	 * 
	 * @param stelle Die zu färbende Stelle
	 */
	public void setBlau(Stelle stelle)
	{
		_blaueStellen.put(stelle.toString(), stelle);
	}

	/**
	 * Gibt die Hoehe des Spielbretts zurück
	 * 
	 * @return Die Hoehe des Spielbretts
	 */
	public int getHoehe()
	{
		return _hoehe;
	}
	
	/**
	 * Gibt die Breite des Spielbretts zurück
	 * 
	 * @return Die Breite des Spielbretts
	 */
	public int getBreite()
	{
		return _breite;
	}
	
	/**
	 * Gibt die Farbe der Stelle als Zahlencode zurück
	 * 1 = rot
	 * 2 = blau
	 * 0 = farblos
	 * 
	 * @param stelle Die Stelle dessen Farbe zurückgegeben werden soll
	 * @return Die Farbe der Stelle als Zahlencode
	 */
	public int getFarbe(Stelle stelle)
	{
		if(_roteStellen.containsValue(stelle))
		{
			return 1;
		}
		else if(_blaueStellen.containsValue(stelle))
		{
			return 2;
		}
		else
		{
			return 0;
		}
	}

	/**
	 * Gibt die Map mit roten Stellen zurück
	 * 
	 * @return Die Map mit roten Stellen
	 */
	public Map<String, Stelle> getRote() 
	{
		return _roteStellen;
	}

	/**
	 * Gibt die Map mit blauen Stellen zurück
	 * 
	 * @return Die Map mit blauen Stellen
	 */
	public Map<String, Stelle> getBlaue() 
	{
		return _blaueStellen;
	}
	
}
