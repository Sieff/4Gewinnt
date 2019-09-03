package Werkzeuge.Spielbrett;


import javax.swing.*;

/**
 * Die UI für das Spielbrett 
 * 
 * @author steff
 *
 */
public class SpielbrettWerkzeugUI 
{
	JPanel _hauptPanel;
	JSpielbrettPlan _spielbrettPlan;
	
	public SpielbrettWerkzeugUI(int hoehe, int breite)
	{
		_hauptPanel = erstelleHauptPanel(hoehe, breite);
	}
	
	/**
	 * Erstellt das Hauptpanel für das Spielbrett
	 * 
	 * @param hoehe Hoehe des Spielbretts
	 * @param breite Breite des Spielbretts
	 * 
	 * @return das Hauptpanel der UI
	 */
	private JPanel erstelleHauptPanel(int hoehe, int breite) 
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		_spielbrettPlan = new JSpielbrettPlan(hoehe, breite);
		panel.add(new JScrollPane(_spielbrettPlan));
		
		return panel;
	}

	/**
	 * Gibt das Hauptpanel der UI zurück
	 * 
	 * @return das Hauptpanel der UI
	 */
	public JPanel getHauptPanel()
	{
		return _hauptPanel;
	}

	/**
	 * Gibt den Spielbrettplan der UI zurück
	 * 
	 * @return der Spielbrettplan der UI
	 */
	public JSpielbrettPlan getSpielbrettPlan() 
	{
		return _spielbrettPlan;
	}
}
