package Werkzeuge.GroessenWahl;

import java.awt.FlowLayout;

import javax.swing.*;

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

	private void initDialog() 
	{
		_dialog = new JDialog();
		_dialog.setLayout(new FlowLayout());
		
		_hoehenLabel = new JLabel("Hoehe: ");
		_breitenLabel = new JLabel("Breite: ");
		
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
	
	public JTextField getHoehenTextField()
	{
		return _hoehe;
	}
	
	public JTextField getBreitenTextField()
	{
		return _breite;
	}
	
	public JButton getOKButton()
	{
		return _OKButton;
	}
	
	public JDialog getDialog()
	{
		return _dialog;
	}
	
}
