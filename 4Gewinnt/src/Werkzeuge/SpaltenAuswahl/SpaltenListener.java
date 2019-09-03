package Werkzeuge.SpaltenAuswahl;

import java.util.EventListener;

/**
 * Ein EventListener für Spaltenauswahl
 * 
 * @author steff
 *
 */
public interface SpaltenListener extends EventListener 
{
	/**
	 * Auswahl zur Spaltenwahl wurde getätigt
	 * 
	 * @param e
	 */
	void auswahlGetaetigt(SpaltenAuswahlEvent e);
}
