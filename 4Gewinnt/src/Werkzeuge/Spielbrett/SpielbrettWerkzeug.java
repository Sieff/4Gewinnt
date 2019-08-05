package Werkzeuge.Spielbrett;

import javax.swing.*;

public class SpielbrettWerkzeug 
{
	SpielbrettWerkzeugUI _UI;
	
	public SpielbrettWerkzeug(int hoehe, int breite)
	{
		erzeugeSpielbrett(hoehe, breite);
		_UI = new SpielbrettWerkzeugUI(hoehe, breite);
	}

	private void erzeugeSpielbrett(int hoehe, int breite) {
		// TODO Auto-generated method stub
		
	}
	
	public JPanel getUIPanel()
	{
		return _UI.getHauptPanel();
	}
	
	
}
