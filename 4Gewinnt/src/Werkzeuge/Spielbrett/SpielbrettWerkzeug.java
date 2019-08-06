package Werkzeuge.Spielbrett;

import javax.swing.*;

import Fachwerte.Stelle;
import Materialien.Spielbrett;

public class SpielbrettWerkzeug 
{
	SpielbrettWerkzeugUI _UI;
	Spielbrett _spielbrett;
	
	public SpielbrettWerkzeug(int hoehe, int breite)
	{
		_spielbrett = erzeugeSpielbrett(hoehe, breite);
		_UI = new SpielbrettWerkzeugUI(hoehe, breite);
	}

	private Spielbrett erzeugeSpielbrett(int hoehe, int breite) 
	{
		return new Spielbrett(hoehe, breite);
	}
	
	public JPanel getUIPanel()
	{
		return _UI.getHauptPanel();
	}
	
	public void setzeRot(Stelle stelle)
	{

		_UI.getSpielbrettPlan().markiereStelleRot(stelle);
	}
	
	public void setzeBlau(Stelle stelle)
	{
		_UI.getSpielbrettPlan().markiereStelleBlau(stelle);
	}
	
	public Spielbrett getSpielbrett()
	{
		return _spielbrett;
	}
}
