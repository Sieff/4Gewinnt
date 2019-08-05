package Werkzeuge.SpaltenAuswahl;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class SpaltenAuswahlWerkzeugUI 
{
	private JPanel _hauptPanel;
	private JSpaltenwahlPlan _spaltenwahlPlan;
	
	public SpaltenAuswahlWerkzeugUI(int breite)
	{
		_hauptPanel = erstelleHauptPanel(breite);
	}
	
	private JPanel erstelleHauptPanel(int breite) 
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		_spaltenwahlPlan = new JSpaltenwahlPlan(breite);
		panel.add(new JScrollPane(_spaltenwahlPlan));
	
		return panel;
	}

	public JPanel getHauptPanel()
	{
		return _hauptPanel;
	}
	
}
