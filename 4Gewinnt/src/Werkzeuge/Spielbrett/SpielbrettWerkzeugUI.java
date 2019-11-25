package Werkzeuge.Spielbrett;


import javax.swing.*;

/**
 * Die UI f�r das Spielbrett 
 * 
 * @author Steffen Schubert
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
	 * Erstellt das Hauptpanel f�r das Spielbrett
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
	 * Gibt das Hauptpanel der UI zur�ck
	 * 
	 * @return das Hauptpanel der UI
	 */
	public JPanel getHauptPanel()
	{
		return _hauptPanel;
	}

	/**
	 * Gibt den Spielbrettplan der UI zur�ck
	 * 
	 * @return der Spielbrettplan der UI
	 */
	public JSpielbrettPlan getSpielbrettPlan() 
	{
		return _spielbrettPlan;
	}
}
