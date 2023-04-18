package Werkzeuge.SpielRahmen;


import javax.swing.BoxLayout;
import javax.swing.*;

/**
 * Sorgt f�r den JFrame in dem alles vorhanden ist
 * 
 * @author Steffen Schubert
 */
public class SpielRahmenWerkzeugUI 
{
	private JFrame _frame;
	
	public SpielRahmenWerkzeugUI(JPanel spielbrettWerkzeugPanel, JPanel spaltenAuswahlWerkzeugPanel, JPanel spielerAnzeigePanel)
	{
		initFrame(spielbrettWerkzeugPanel, spaltenAuswahlWerkzeugPanel, spielerAnzeigePanel);
	}
	
	/**
	 * Initialisiert den Haupt-Frame f�r das Spiel
	 * 
	 * @param spielbrettWerkzeugPanel Das Panel f�r das Spielbrett
	 * @param spaltenAuswahlWerkzeugPanel Das Panel f�r die Auswahl der Spalte
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
	 * Gibt den Haupt-JFrame zur�ck
	 * @return der JFrame des Spiels
	 */
	public JFrame getFrame()
	{
		return _frame;
	}
}