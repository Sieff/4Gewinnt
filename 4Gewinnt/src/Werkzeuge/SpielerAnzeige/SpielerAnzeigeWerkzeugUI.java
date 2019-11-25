package Werkzeuge.SpielerAnzeige;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Die UI f�r das Anzeigen welcher Spieler am Zug ist
 * 
 * @author Steffen Schubert
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
	 * Initialisiert das JPanel f�r die Spieleranzeige
	 */
	private void initPanel() 
	{
		_panel = new JPanel();
		
		_panel.add(_label);
	}
	
	/**
	 * Gibt das JPanel f�r die Spieleranzeige zur�ck
	 * @return JPanel _panel
	 */
	public JPanel getPanel()
	{
		return _panel;
	}

	/**
	 * Setzt das Label f�r die Spieleranzeige auf spieler
	 * @param spieler der aktuelle Spieler
	 */
	public void setLabel(String spieler) 
	{
		_label.setText(spieler + " ist dran");
	}
}
