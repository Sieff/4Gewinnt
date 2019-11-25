package Werkzeuge.SpaltenAuswahl;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Die UI zur Auswahl der Spalte
 * 
 * @author Steffen Schubert
 *
 */
public class SpaltenAuswahlWerkzeugUI 
{
	private JPanel _hauptPanel;
	private JSpaltenwahlPlan _spaltenwahlPlan;
	
	public SpaltenAuswahlWerkzeugUI(int breite)
	{
		_hauptPanel = erstelleHauptPanel(breite);
	}
	
	/**
	 * Erstellt das Hauptpanel zur Auswahl der Spalte
	 * 
	 * @param breite Die breite des Spielfelds und somit der Spaltenauswahl
	 * @return das Hauptpanel der Spaltenauswahl
	 */
	private JPanel erstelleHauptPanel(int breite) 
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		_spaltenwahlPlan = new JSpaltenwahlPlan(breite);
		panel.add(new JScrollPane(_spaltenwahlPlan));
	
		return panel;
	}

	/**
	 * Gibt das Hauptpanel der Spaltenauswahl zur�ck.
	 * 
	 * @return Das Hauptpanel
	 */
	public JPanel getHauptPanel()
	{
		return _hauptPanel;
	}
	
	/**
	 * Gibt den JSpaltenwahlPlan zur�ck
	 *  
	 * @return der Spaltenwahlplan
	 */
	public JSpaltenwahlPlan getSpaltenwahlPlan()
	{
		return _spaltenwahlPlan;
	}

}
