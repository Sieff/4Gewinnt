package Werkzeuge.SpielerAnzeige;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpielerAnzeigeWerkzeugUI 
{
	private JPanel _panel;
	private JLabel _label;
	
	public SpielerAnzeigeWerkzeugUI() 
	{
		_label = new JLabel("Rot ist dran");
		initPanel();
	}
	
	private void initPanel() 
	{
		_panel = new JPanel();
		
		_panel.add(_label);
	}
	
	public JPanel getPanel()
	{
		return _panel;
	}

	public void setLabel(String spieler) 
	{
		_label.setText(spieler + " ist dran");
	}
}
