package Materialien;

import java.util.*;

import Fachwerte.Stelle;

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
	
	public void setRot(Stelle stelle)
	{
		_roteStellen.put(stelle.toString(), stelle);
	}
	
	public void setBlau(Stelle stelle)
	{
		_blaueStellen.put(stelle.toString(), stelle);
	}

	public int getHoehe()
	{
		return _hoehe;
	}

	public Map<String, Stelle> getRote() 
	{
		return _roteStellen;
	}

	public Map<String, Stelle> getBlaue() 
	{
		return _blaueStellen;
	}
	
}
