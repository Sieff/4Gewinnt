package Werkzeuge.SpaltenAuswahl;

import java.util.EventListener;

/**
 * Ein EventListener f�r Spaltenauswahl
 * 
 * @author steff
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
