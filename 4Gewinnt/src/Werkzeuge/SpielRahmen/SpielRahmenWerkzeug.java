package Werkzeuge.SpielRahmen;

import Services.SteinSetzerService;
import Werkzeuge.SpaltenAuswahl.SpaltenAuswahlWerkzeug;
import Werkzeuge.Spielbrett.SpielbrettWerkzeug;

public class SpielRahmenWerkzeug 
{
	private SpielRahmenWerkzeugUI _UI;
	private SpaltenAuswahlWerkzeug _spaltenAuswahlWerkzeug;
	private SpielbrettWerkzeug _spielbrettWerkzeug;
	private SteinSetzerService _service;
	
	public SpielRahmenWerkzeug(int hoehe, int breite)
	{
		_spielbrettWerkzeug = new SpielbrettWerkzeug(hoehe, breite);
		_service = new SteinSetzerService(_spielbrettWerkzeug, _spielbrettWerkzeug.getSpielbrett());

		_spaltenAuswahlWerkzeug = new SpaltenAuswahlWerkzeug(breite, _service);
		
		_UI = new SpielRahmenWerkzeugUI(_spielbrettWerkzeug.getUIPanel(), _spaltenAuswahlWerkzeug.getUIPanel());
		
		_UI.zeigeAn();
	}
	
	public SteinSetzerService getService()
	{
		return _service;
	}
}
