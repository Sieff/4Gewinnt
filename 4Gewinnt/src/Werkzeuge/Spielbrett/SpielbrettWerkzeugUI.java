package Werkzeuge.Spielbrett;


import javax.swing.*;

public class SpielbrettWerkzeugUI 
{
	JPanel _hauptPanel;
	JSpielbrettPlan _spielbrettPlan;
	
	public SpielbrettWerkzeugUI(int hoehe, int breite)
	{
		_hauptPanel = erstelleHauptPanel(hoehe, breite);
	}
	
	private JPanel erstelleHauptPanel(int hoehe, int breite) 
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		_spielbrettPlan = new JSpielbrettPlan(hoehe, breite);
		panel.add(new JScrollPane(_spielbrettPlan));
		
		return panel;
	}

	public JPanel getHauptPanel()
	{
		return _hauptPanel;
	}

	public JSpielbrettPlan getSpielbrettPlan() 
	{
		return _spielbrettPlan;
	}
}
