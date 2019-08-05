package Werkzeuge.SpielRahmen;


import javax.swing.BoxLayout;
import javax.swing.*;

public class SpielRahmenWerkzeugUI 
{
	private JFrame _frame;
	
	public SpielRahmenWerkzeugUI(JPanel spielbrettWerkzeugPanel, JPanel spaltenAuswahlWerkzeugPanel)
	{
		initFrame(spielbrettWerkzeugPanel, spaltenAuswahlWerkzeugPanel);
	}
	
	private void initFrame(JPanel spielbrettWerkzeugPanel, JPanel spaltenAuswahlWerkzeugPanel)
	{
		_frame = new JFrame();
		_frame.setLayout(new BoxLayout(_frame.getContentPane(), BoxLayout.Y_AXIS));
		
		_frame.add(spielbrettWerkzeugPanel);
		_frame.add(spaltenAuswahlWerkzeugPanel);
		_frame.pack();
		_frame.setResizable(false);
		_frame.setLocation(200, 200);
		
	}
	
	public void zeigeAn()
	{
		_frame.setVisible(true);
	}
}