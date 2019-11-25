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
	private String _gewinnerText; 
	private JFrame _frame;
	private JButton _neuGleich;
	private JButton _neuAnders;
	
	public SpielEndeWerkzeugUI(boolean unentschieden, boolean rotGewonnen) 
	{
		if(unentschieden)
		{
			_gewinnerText = "Es ist ein Unentschieden!";
		}
		else if(rotGewonnen)
		{
			_gewinnerText = "Rot hat gewonnen!";
		}
		else
		{
			_gewinnerText = "Blau hat gewonnen!";
		}
		initFrame();
	}
	
	/**
	 * Initialisiert den JFrame f�r das Spielende
	 */
	private void initFrame()
	{
		_frame = new JFrame();
		_frame.setLayout(new GridLayout(2,2));
		
		_neuGleich = new JButton("Neues Spiel");
		_neuAnders = new JButton("Andere Spielfeldgroeße waehlen");
		
		_frame.add(new JLabel(_gewinnerText));
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
	 * Gibt den JFrame zum Spielende zur�ck
	 * 
	 * @return JFrame f�r Spielende
	 */
	public JFrame getFrame()
	{
		return _frame;
	}
	
	/**
	 * Gibt den JButton zur�ck, der genutzt wird um ein neues Spiel anzufangen
	 * 
	 * @return JButton f�r neues Spiel
	 */
	public JButton getNextButton()
	{
		return _neuGleich;
	}
	
	/**
	 * Gibt den JButton zur�ck, der genutzt wird um eine andere Spielfeldgroe�e auszuwaehlen
	 * 
	 * @return JButton um neue Groe�e zu waehlen
	 */
	public JButton getNewButton()
	{
		return _neuAnders;
	}
}
