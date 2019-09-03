package Werkzeuge.SpielEnde;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Die UI mit JFrame die erscheint wenn ein Spieler gewinnt
 * 
 * @author steff
 *
 */
public class SpielEndeWerkzeugUI 
{
	private String _gewinner; 
	private JFrame _frame;
	private JButton _neuGleich;
	private JButton _neuAnders;
	
	public SpielEndeWerkzeugUI(boolean rotGewonnen) 
	{
		if(rotGewonnen)
		{
			_gewinner = "Rot";
		}
		else
		{
			_gewinner = "Blau";
		}
		initFrame();
	}
	
	/**
	 * Initialisiert den JFrame für das Spielende
	 */
	private void initFrame()
	{
		_frame = new JFrame();
		_frame.setLayout(new GridLayout(2,2));
		
		_neuGleich = new JButton("Neues Spiel");
		_neuAnders = new JButton("Andere Spielfeldgroeße wählen");
		
		_frame.add(new JLabel(_gewinner + " hat gewonnen!"));
		_frame.add(new JLabel(""));
		_frame.add(_neuGleich);
		_frame.add(_neuAnders);
		
		_frame.pack();
		_frame.setResizable(false);
		_frame.setLocation(300, 100);
		
	}

	/**
	 * Setzt den JFrame zum Spielende sichtbar
	 */
	public void zeigeAn() 
	{
		_frame.setVisible(true);
	}
	
	/**
	 * Gibt den JFrame zum Spielende zurück
	 * 
	 * @return JFrame für Spielende
	 */
	public JFrame getFrame()
	{
		return _frame;
	}
	
	/**
	 * Gibt den JButton zurück, der genutzt wird um ein neues Spiel anzufangen
	 * 
	 * @return JButton für neues Spiel
	 */
	public JButton getNextButton()
	{
		return _neuGleich;
	}
	
	/**
	 * Gibt den JButton zurück, der genutzt wird um eine andere Spielfeldgroeße auszuwaehlen
	 * 
	 * @return JButton um neue Groeße zu waehlen
	 */
	public JButton getNewButton()
	{
		return _neuAnders;
	}
}
