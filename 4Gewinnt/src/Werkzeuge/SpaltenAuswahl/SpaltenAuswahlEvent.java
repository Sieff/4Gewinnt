package Werkzeuge.SpaltenAuswahl;

import java.util.EventObject;

public class SpaltenAuswahlEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	int _ausgewaehlteSpalte;
	
	public SpaltenAuswahlEvent(Object source, int spalte)
	{
		super(source);
		_ausgewaehlteSpalte = spalte;
	}
	
	public int getAusgewaehlteSpalte()
	{
		return _ausgewaehlteSpalte;
	}
	
	public String toString()
	{
		return "Ausgewaehlte Spalte: " + _ausgewaehlteSpalte;
	}
}
