package Werkzeuge.Spielbrett;

import javax.swing.*;

import Fachwerte.Stelle;
import Materialien.Spielbrett;

/**
 * Sorgt f�r die SpielbrettUI und das Spielbrett
 * 
 * @author Steffen Schubert
 *
 */
public class SpielbrettWerkzeug 
{
	SpielbrettWerkzeugUI _UI;
	Spielbrett _spielbrett;
	
	public SpielbrettWerkzeug(int hoehe, int breite)
	{
		_spielbrett = erzeugeSpielbrett(hoehe, breite);
		_UI = new SpielbrettWerkzeugUI(hoehe, breite);
	}

	/**
	 * Erzeugt das Spielbrett
	 *  
	 * @param hoehe Hoehe des Spielbretts
	 * @param breite Breite des Spielbretts
	 * @return das Spielbrett
	 */
	private Spielbrett erzeugeSpielbrett(int hoehe, int breite) 
	{
		return new Spielbrett(hoehe, breite);
	}
	
	/**
	 * Gibt das Hauptpanel der UI zur�ck
	 * 
	 * @return das Hauptpanel der UI
	 */
	public JPanel getUIPanel()
	{
		return _UI.getHauptPanel();
	}
	
	/**
	 * Setzt die �bergebene Stelle rot
	 * 
	 * @param stelle die zu setzende Stelle
	 */
	public void setzeRot(Stelle stelle)
	{

		_UI.getSpielbrettPlan().markiereStelleRot(stelle);
	}
	
	/**
	 * Setzt die �bergebene Stelle blau
	 * 
	 * @param stelle die zu setzende Stelle
	 */
	public void setzeBlau(Stelle stelle)
	{
		_UI.getSpielbrettPlan().markiereStelleBlau(stelle);
	}
	
	/**
	 * Gibt das Spielbrett zur�ck
	 * 
	 * @return das Spielbrett
	 */
	public Spielbrett getSpielbrett()
	{
		return _spielbrett;
	}
}
