package Werkzeuge.SpaltenAuswahl;

import javax.swing.JPanel;

import Werkzeuge.ObservableSubwerkzeug;
import Werkzeuge.SpielRahmen.SpielRahmenWerkzeug;

/**
 * Sorgt für die UI zur Auswahl der Spalte
 * 
 * @author steff
 *
 */
public class SpaltenAuswahlWerkzeug extends ObservableSubwerkzeug
{
	private SpaltenAuswahlWerkzeugUI _UI;
	private int _ausgewaehlteSpalte;
	
	public SpaltenAuswahlWerkzeug(int breite, SpielRahmenWerkzeug spielRahmenWerkzeug)
	{
		registriereBeobachter(spielRahmenWerkzeug);
		_UI = new SpaltenAuswahlWerkzeugUI(breite);
		registriereUIAktionen();
	}
	
	/**
	 * Registriert Aktionen in der UI
	 */
	private void registriereUIAktionen() 
	{
		_UI.getSpaltenwahlPlan().addSpaltenAuswahlListener(new SpaltenListener()
				{

					@Override
					public void auswahlGetaetigt(SpaltenAuswahlEvent e) 
					{
						_ausgewaehlteSpalte = e.getAusgewaehlteSpalte();
						informiereUeberAenderung();
					}
			
				});
		
		//TODO Eingabe mit Zahlen
//		_UI.getSpaltenwahlPlan().addKeyListener(new KeyAdapter() 
//			{
//				@Override
//				public void keyReleased(KeyEvent e)
//				{
//					try
//					{
//						String s = "" + e.getKeyChar();
//						_ausgewaehlteSpalte = Integer.parseInt(s);
//						informiereUeberAenderung();
//					}
//					catch(NumberFormatException g){
//						
//					}
//				}
//			});
	}

	/**
	 * Gibt das JPanel der UI zurück
	 * 
	 * @return Das JPanel der Spaltenauswahl-UI
	 */
	public JPanel getUIPanel()
	{
		return _UI.getHauptPanel();
	}
	
	/**
	 * Gibt die ausgewaehlte Spalte als int zurück
	 * @return Die ausgewaehlte Spalte als int
	 */
	public int getAusgewaehlteSpalte()
	{
		return _ausgewaehlteSpalte;
	}
}
