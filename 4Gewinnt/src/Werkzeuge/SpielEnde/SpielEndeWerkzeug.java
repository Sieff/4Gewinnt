package Werkzeuge.SpielEnde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Werkzeuge.ObservableSubwerkzeug;
import Werkzeuge.GroessenWahl.GroessenwahlWerkzeug;
import Werkzeuge.SpielRahmen.SpielRahmenWerkzeug;

/**
 * Sorgt f�r die UI, wenn jemand das Spiel Gewonnen hat
 * 
 * @author steff
 *
 */
public class SpielEndeWerkzeug extends ObservableSubwerkzeug
{
	private boolean _rotGewonnen;
	private SpielEndeWerkzeugUI _UI;
	private int _alteHoehe;
	private int _alteBreite;
	private boolean _fensterSchließen;
	private boolean _unentschieden;
	
	public SpielEndeWerkzeug(boolean blauWarDran, boolean unentschieden, int hoehe, int breite, SpielRahmenWerkzeug observer)
	{
		_unentschieden = unentschieden;
		_rotGewonnen = !blauWarDran;
		_alteHoehe = hoehe;
		_alteBreite = breite;
		_fensterSchließen = false;
		registriereBeobachter(observer);
		_UI = new SpielEndeWerkzeugUI(_unentschieden, _rotGewonnen);
		
		_UI.zeigeAn();
		
		registriereUIAktionen();
	}
	
	/**
	 * Registriert UI-Aktionen
	 */
	private void registriereUIAktionen() 
	{
		_UI.getNextButton().addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				reagiereAufEingabe();
				new SpielRahmenWerkzeug(_alteHoehe, _alteBreite);
			}
		});
		
		_UI.getNewButton().addActionListener(new ActionListener()
		{	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				reagiereAufEingabe();
				new GroessenwahlWerkzeug();
			}
		});
	}
	
	/**
	 * Reagiert auf das dr�cken eines Buttons in der SpielEndeUI
	 */
	private void reagiereAufEingabe()
	{
		_UI.getFrame().dispose();
		_fensterSchließen = true;
		informiereUeberAenderung();
	}
	
	/**
	 * Gibt zur�ck ob das Fenster mit dem Spiel geschlossen werden soll
	 * 
	 * @return boolean _fensterSchlie0en
	 */
	public boolean getFensterSchließen()
	{
		return _fensterSchließen;
	}
}
