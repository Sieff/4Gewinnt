package Werkzeuge.SpielEnde;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Werkzeuge.ObservableSubwerkzeug;
import Werkzeuge.GroessenWahl.GroessenwahlWerkzeug;
import Werkzeuge.SpielRahmen.SpielRahmenWerkzeug;

/**
 * Sorgt f¸r die UI, wenn jemand das Spiel Gewonnen hat
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
	private boolean _fensterSchlieﬂen;
	
	public SpielEndeWerkzeug(boolean blauWarDran, int hoehe, int breite, SpielRahmenWerkzeug observer)
	{
		_rotGewonnen = !blauWarDran;
		_alteHoehe = hoehe;
		_alteBreite = breite;
		_fensterSchlieﬂen = false;
		registriereBeobachter(observer);
		_UI = new SpielEndeWerkzeugUI(_rotGewonnen);
		
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
	
	private void reagiereAufEingabe()
	{
		_UI.getFrame().dispose();
		_fensterSchlieﬂen = true;
		informiereUeberAenderung();
	}
	
	public boolean getFensterSchlieﬂen()
	{
		return _fensterSchlieﬂen;
	}
}
