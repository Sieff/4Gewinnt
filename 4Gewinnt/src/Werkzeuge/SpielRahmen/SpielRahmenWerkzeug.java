package Werkzeuge.SpielRahmen;

import Werkzeuge.SpaltenAuswahl.SpaltenAuswahlWerkzeug;
import Werkzeuge.Spielbrett.SpielbrettWerkzeug;

public class SpielRahmenWerkzeug 
{
	private SpielRahmenWerkzeugUI _UI;
	SpaltenAuswahlWerkzeug _spaltenAuswahlWerkzeug;
	SpielbrettWerkzeug _spielbrettWerkzeug;
	
	public SpielRahmenWerkzeug(int hoehe, int breite)
	{
		_spaltenAuswahlWerkzeug = new SpaltenAuswahlWerkzeug(breite);
		_spielbrettWerkzeug = new SpielbrettWerkzeug(hoehe, breite);
		
		_UI = new SpielRahmenWerkzeugUI(_spielbrettWerkzeug.getUIPanel(), _spaltenAuswahlWerkzeug.getUIPanel());
		
		_UI.zeigeAn();
	}

	
}
