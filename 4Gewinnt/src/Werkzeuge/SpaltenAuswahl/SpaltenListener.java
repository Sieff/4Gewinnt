package Werkzeuge.SpaltenAuswahl;

import java.util.EventListener;

/**
 * Ein EventListener f�r Spaltenauswahl
 * 
 * @author Steffen Schubert
 *
 */
public interface SpaltenListener extends EventListener 
{
	/**
	 * Auswahl zur Spaltenwahl wurde get�tigt
	 * 
	 * @param e
	 */
	void auswahlGetaetigt(SpaltenAuswahlEvent e);
}
