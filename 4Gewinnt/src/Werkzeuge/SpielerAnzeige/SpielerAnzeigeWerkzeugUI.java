package Werkzeuge.SpielerAnzeige;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Die UI für das Anzeigen welcher Spieler am Zug ist
 * 
 * @author steff
 *
 */
public class SpielerAnzeigeWerkzeugUI 
{
	private JPanel _panel;
	private JLabel _label;
	
	public SpielerAnzeigeWerkzeugUI() 
	{
		_label = new JLabel("Rot ist dran");
		initPanel();
	}
	
	/**
	 * Initialisiert das JPanel für die Spieleranzeige
	 */
	private void initPanel() 
	{
		_panel = new JPanel();
		
		_panel.add(_label);
	}
	
	/**
	 * Gibt das JPanel für die Spieleranzeige zurück
	 * @return JPanel _panel
	 */
	public JPanel getPanel()
	{
		return _panel;
	}

	/**
	 * Setzt das Label für die Spieleranzeige auf spieler
	 * @param spieler der aktuelle Spieler
	 */
	public void setLabel(String spieler) 
	{
		_label.setText(spieler + " ist dran");
	}
}
