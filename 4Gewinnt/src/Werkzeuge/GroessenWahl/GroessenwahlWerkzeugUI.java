package Werkzeuge.GroessenWahl;

import java.awt.FlowLayout;

import javax.swing.*;

/**
 * Die UI f�r die Groessenauswahl
 * 
 * @author Steffen Schubert
 *
 */
public class GroessenwahlWerkzeugUI 
{
	private JDialog _dialog;
	private JTextField _hoehe;
	private JTextField _breite;
	private JLabel _hoehenLabel;
	private JLabel _breitenLabel;
	private JButton _OKButton;
	
	public GroessenwahlWerkzeugUI()
	{
		initDialog();
	}

	/**
	 * Initialisiert den Dialog f�r die Groessenauswahl
	 */
	private void initDialog() 
	{
		_dialog = new JDialog();
		_dialog.setLayout(new FlowLayout());
		
		_hoehenLabel = new JLabel("Hoehe (Max. 10): ");
		_breitenLabel = new JLabel("Breite (Max. 10): ");
		
		_hoehe = new JTextField(12);
		_breite = new JTextField(12);
		
		_OKButton = new JButton("OK");
		
		_dialog.add(_hoehenLabel);
		_dialog.add(_hoehe);
		_dialog.add(_breitenLabel);
		_dialog.add(_breite);
		_dialog.add(_OKButton);
		
		_dialog.pack();
		_dialog.setResizable(false);
		_dialog.setLocation(500, 200);
		_dialog.setVisible(true);
	}
	
	/**
	 * Gibt das Hoehentextfeld zur�ck
	 * 
	 * @return das Textfeld zur auswahl der Hoehe
	 */
	public JTextField getHoehenTextField()
	{
		return _hoehe;
	}
	
	/**
	 * Gibt das Breitentextfeld zur�ck
	 * 
	 * @return das Textfeld zur auswahl der Breite
	 */
	public JTextField getBreitenTextField()
	{
		return _breite;
	}
	
	/**
	 * Gibt den OK-Butten zur�ck
	 * 
	 * @return der OK-Button 
	 */
	public JButton getOKButton()
	{
		return _OKButton;
	}
	
	/**
	 * Gibt den Dialog zur�ck
	 * 
	 * @return der Dialog
	 */
	public JDialog getDialog()
	{
		return _dialog;
	}
	
}
