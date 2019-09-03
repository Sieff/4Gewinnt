package Werkzeuge.SpielRahmen;


import javax.swing.BoxLayout;
import javax.swing.*;

/**
 * Sorgt für den JFrame in dem alles vorhanden ist
 * @author steff
 *
 */
public class SpielRahmenWerkzeugUI 
{
	private JFrame _frame;
	
	public SpielRahmenWerkzeugUI(JPanel spielbrettWerkzeugPanel, JPanel spaltenAuswahlWerkzeugPanel, JPanel spielerAnzeigePanel)
	{
		initFrame(spielbrettWerkzeugPanel, spaltenAuswahlWerkzeugPanel, spielerAnzeigePanel);
	}
	
	/**
	 * Initialisiert den Haupt-Frame für das Spiel
	 * 
	 * @param spielbrettWerkzeugPanel Das Panel für das Spielbrett
	 * @param spaltenAuswahlWerkzeugPanel Das Panel für die Auswahl der Spalte
	 * @param spielerAnzeigePanel Das Panel zur Anzeige des momentanen Spielers
	 */
	private void initFrame(JPanel spielbrettWerkzeugPanel, JPanel spaltenAuswahlWerkzeugPanel, JPanel spielerAnzeigePanel)
	{
		_frame = new JFrame();
		_frame.setLayout(new BoxLayout(_frame.getContentPane(), BoxLayout.Y_AXIS));
		
		_frame.add(spielerAnzeigePanel);
		_frame.add(spielbrettWerkzeugPanel);
		_frame.add(spaltenAuswahlWerkzeugPanel);
		_frame.pack();
		_frame.setResizable(false);
		_frame.setLocation(300, 200);
		
	}
	
	/**
	 * Setzt die UI auf sichtbar
	 */
	public void zeigeAn()
	{
		_frame.setVisible(true);
	}
	
	/**
	 * Gibt den Haupt-JFrame zurück
	 * @return der JFrame des Spiels
	 */
	public JFrame getFrame()
	{
		return _frame;
	}
}