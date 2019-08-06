package Fachwerte;

import java.util.*;

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
	
	public static Stelle get(int hoehe, int breite)
	{
		if(!_stellen.containsKey(hoehe + "," + breite))
		{
			_stellen.put(hoehe + "," + breite , new Stelle(hoehe, breite));
		}
		
		return _stellen.get(hoehe + "," + breite);
	}
	
	public int getHoehenKoordinate()
	{
		return _hoehenKoordinate;
	}
	
	public int getBreitenKoordinate()
	{
		return _breitenKoordinate;
	}
	
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
	
	public int hashCode()
	{
		return 420 * 69 * _hoehenKoordinate + _breitenKoordinate;
	}
	
	public String toString()
	{
		return this._hoehenKoordinate + "," + this._breitenKoordinate;
	}
}
