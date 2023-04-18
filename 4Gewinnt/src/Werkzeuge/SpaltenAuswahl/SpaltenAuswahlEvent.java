package Werkzeuge.SpaltenAuswahl;

import java.util.EventObject;

/**
 * Ein SpaltenauswahlEvent, dass ein EventObject ist und durch die ausgewaehlte Spalte beschrieben wird
 * 
 * @author Steffen Schubert
 *
 */
public class SpaltenAuswahlEvent extends EventObject
{
	private static final long serialVersionUID = 1L;
	private int _ausgewaehlteSpalte;
	
	public SpaltenAuswahlEvent(Object source, int spalte)
	{
		super(source);
		_ausgewaehlteSpalte = spalte;
	}
	
	/**
	 * Gibt die ausgewaehlte Spalte zurueck
	 * 
	 * @return Die ausgewaehlte Spalte
	 */
	public int getAusgewaehlteSpalte()
	{
		return _ausgewaehlteSpalte;
	}
	
}
