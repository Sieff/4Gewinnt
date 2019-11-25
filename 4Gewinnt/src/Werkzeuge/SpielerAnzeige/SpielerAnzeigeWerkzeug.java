package Werkzeuge.SpielerAnzeige;

import javax.swing.JPanel;

/**
 * Sorgt f�r die UI mit dem JPanel, dass den aktuellen Spieler anzeigt
 * 
 * @author Steffen Schubert
 *
 */
public class SpielerAnzeigeWerkzeug 
{
	private SpielerAnzeigeWerkzeugUI _UI;
	
	public SpielerAnzeigeWerkzeug() 
	{
		_UI = new SpielerAnzeigeWerkzeugUI();
	}

	/**
	 * Gibt das UI-Panel der UI zur�ck
	 * @return das JPanel der UI
	 */
	public JPanel getUIPanel() 
	{
		return _UI.getPanel();
	}

	/**
	 * �ndert das JLabel in der UI zum entsprechenden Spieler
	 * @param _rotIstDran Ob rot gerade dran ist
	 */
	public void aendereSpieler(boolean _rotIstDran) 
	{
		if(_rotIstDran)
		{
			_UI.setLabel("Rot");
		}
		else
		{
			_UI.setLabel("Blau");
		}
		
	}

}
