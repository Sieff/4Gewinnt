package Werkzeuge.SpaltenAuswahl;

import javax.swing.JPanel;

public class SpaltenAuswahlWerkzeug 
{
	private SpaltenAuswahlWerkzeugUI _UI;
	
	
	public SpaltenAuswahlWerkzeug(int breite)
	{
		_UI = new SpaltenAuswahlWerkzeugUI(breite);
	}
	
	public JPanel getUIPanel()
	{
		return _UI.getHauptPanel();
	}
}
