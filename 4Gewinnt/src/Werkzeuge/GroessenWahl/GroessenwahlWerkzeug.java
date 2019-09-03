package Werkzeuge.GroessenWahl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Werkzeuge.SpielRahmen.SpielRahmenWerkzeug;

/**
 * Sorgt für UI zur Auswahl der Groesse des Spielbretts
 * 
 * @author steff
 *
 */
public class GroessenwahlWerkzeug 
{
	private int _hoehe;
	private int _breite;
	private GroessenwahlWerkzeugUI _UI;

	public GroessenwahlWerkzeug()
	{
		_UI = new GroessenwahlWerkzeugUI();
		registriereUIAktionen();
	}

	/**
	 * Registriert UI-Aktionen
	 */
	private void registriereUIAktionen() 
	{
		_UI.getBreitenTextField().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				reagiereAufEingabe();
			}

		});

		_UI.getHoehenTextField().addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				reagiereAufEingabe();
			}

		});


		_UI.getOKButton().addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				reagiereAufEingabe();	
			}
		});
	}

	/**
	 * Reagiert auf eine Eingabe in den Textfields
	 */
	private void reagiereAufEingabe()
	{
		try
		{
 			String breite = _UI.getBreitenTextField().getText();
			String hoehe = _UI.getHoehenTextField().getText();
			
			_breite = Integer.parseInt(breite);
			_hoehe = Integer.parseInt(hoehe);
			
			if(_breite <= 10 && _hoehe <= 10)
			{
				_UI.getDialog().dispose();
				new SpielRahmenWerkzeug(_hoehe, _breite);
			}
		}
		catch(NumberFormatException e)
		{
			
		}
	}

	

}
