package Werkzeuge.SpielRahmen;

import Fachwerte.Stelle;
import Services.GewinnService;
import Services.SteinSetzerService;
import Werkzeuge.SubwerkzeugObserver;
import Werkzeuge.SpaltenAuswahl.SpaltenAuswahlWerkzeug;
import Werkzeuge.SpielEnde.SpielEndeWerkzeug;
import Werkzeuge.Spielbrett.SpielbrettWerkzeug;
import Werkzeuge.SpielerAnzeige.SpielerAnzeigeWerkzeug;

/**
 * Oberwerkzeug f�r das Spiel
 * 
 * @author Steffen Schubert
 *
 */
public class SpielRahmenWerkzeug  implements SubwerkzeugObserver
{
	private SpielRahmenWerkzeugUI _UI;
	private SpaltenAuswahlWerkzeug _spaltenAuswahlWerkzeug;
	private SpielbrettWerkzeug _spielbrettWerkzeug;
	private SpielerAnzeigeWerkzeug _spielerAnzeigeWerkzeug;
	private SpielEndeWerkzeug _spielEndeWerkzeug;
	private SteinSetzerService _steinSetzerService;
	private GewinnService _gewinnService;
	private boolean _rotIstDran;
	private boolean _spielVorbei;
	private int _hoehe;
	private int _breite;
	private int _spielfeldGroeße;
	private int _rundenZaehler;
	
	
	public SpielRahmenWerkzeug(int hoehe, int breite)
	{
		_rotIstDran = true;
		_spielVorbei = false;
		_hoehe = hoehe;
		_breite = breite;
		
		_rundenZaehler = 0;
		
		_spielfeldGroeße = hoehe * breite;
		
		_spielbrettWerkzeug = new SpielbrettWerkzeug(_hoehe, _breite);
		_spaltenAuswahlWerkzeug = new SpaltenAuswahlWerkzeug(_breite, this);
		_spielerAnzeigeWerkzeug = new SpielerAnzeigeWerkzeug();
		
		_gewinnService = new GewinnService(_spielbrettWerkzeug.getSpielbrett());
		_steinSetzerService = new SteinSetzerService(_spielbrettWerkzeug.getSpielbrett());
		
		_UI = new SpielRahmenWerkzeugUI(_spielbrettWerkzeug.getUIPanel(), _spaltenAuswahlWerkzeug.getUIPanel(), _spielerAnzeigeWerkzeug.getUIPanel());
		
		_UI.zeigeAn();
	}
	
	/**
	 * Setzt einen Stein in der �bergebenen Spalte
	 * 
	 * @param spalte die Spalte in der ein Stein gesetzt werden soll
	 */
	public void setzeStein(int spalte)
	{
		Stelle steinHier = _steinSetzerService.berechneStein(spalte);
		if(!istStelleZuHoch(steinHier) && !_spielVorbei)
			{
				if(_rotIstDran)
				{
					setzeRot(steinHier);
					_rotIstDran = false;
				}
				else
				{
					setzeBlau(steinHier);
					_rotIstDran = true;
				}
				
				_rundenZaehler++;
				aendereSpieleranzeige();
				
				if(_gewinnService.pruefeAufGewinner(steinHier) || _rundenZaehler == _spielfeldGroeße)
					{
						_spielEndeWerkzeug = new SpielEndeWerkzeug(_rotIstDran, _rundenZaehler == _spielfeldGroeße,  _hoehe, _breite, this);
						_spielVorbei = true;
					}
			}
	}

	/**
	 * �ndert die Spieleranzeige oben
	 */
	private void aendereSpieleranzeige()
	{
		_spielerAnzeigeWerkzeug.aendereSpieler(_rotIstDran);
	}
	
	/**
	 * Setzt eine Stelle rot
	 * 
	 * @param stelle die zu setzende Stelle
	 */
	private void setzeRot(Stelle stelle) 
	{
		_spielbrettWerkzeug.setzeRot(stelle);
		_steinSetzerService.setzeRot(stelle);
	}

	/**
	 * Setzt eine Stelle blau
	 * 
	 * @param stelle die zu setzende Stelle
	 */
	private void setzeBlau(Stelle stelle) 
	{
		_spielbrettWerkzeug.setzeBlau(stelle);
		_steinSetzerService.setzeBlau(stelle);
		
	}

	/**
	 * Pr�ft ob die Stelle zu hoch ist
	 * 
	 * @param stelle die zu pr�fende Stelle
	 * @returnob die Stelle zu hoch ist
	 */
	private boolean istStelleZuHoch(Stelle stelle)
	{
		return stelle.getHoehenKoordinate() < 0;
	}

	@Override
	public void reagiereAufAenderung() 
	{
		if(!_spielVorbei)
		{
			setzeStein(_spaltenAuswahlWerkzeug.getAusgewaehlteSpalte());
		}
		else
		{
			if(_spielEndeWerkzeug.getFensterSchließen())
			{
				_UI.getFrame().dispose();
			}
		}
	}
}
