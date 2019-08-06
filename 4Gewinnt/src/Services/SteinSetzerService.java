package Services;

import Fachwerte.Stelle;
import Materialien.Spielbrett;
import Werkzeuge.Spielbrett.SpielbrettWerkzeug;

public class SteinSetzerService 
{
	private boolean _rotIstDran;
	private SpielbrettWerkzeug _spielbrettWerkzeug;
	private Spielbrett _spielbrett;
	
	public SteinSetzerService(SpielbrettWerkzeug werkzeug, Spielbrett spielbrett)
	{
		_spielbrettWerkzeug = werkzeug;
		_rotIstDran = true;
		_spielbrett = spielbrett;
	}

	public void setzeStein(int spalte) 
	{
		int richtigeSpalte = spalte -1;
		Stelle steinHier;
		int hoehe = berechneNiedrigsteHoehe(richtigeSpalte);
		steinHier = Stelle.get(hoehe, richtigeSpalte);
		if(!istStelleZuHoch(steinHier))
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
		}
	}

	private boolean istStelleZuHoch(Stelle stelle)
	{
		return stelle.getHoehenKoordinate() < 0;
	}

	private void setzeRot(Stelle stelle) 
	{
		
		_spielbrettWerkzeug.setzeRot(stelle);
		_spielbrett.getRote().put(stelle.toString(), stelle);
	}


	private int berechneNiedrigsteHoehe(int spalte) 
	{
		int i = _spielbrett.getHoehe()-1;
		while(istStelleBesetzt(Stelle.get(i, spalte)))
		{
			i--;
		}
		
		return i;
		
	}

	private void setzeBlau(Stelle stelle) 
	{
		
		_spielbrettWerkzeug.setzeBlau(stelle);	
		_spielbrett.getBlaue().put(stelle.toString(), stelle);
	}
	
	private boolean istStelleBesetzt(Stelle stelle)
	{
		return _spielbrett.getBlaue().containsKey(stelle.toString()) || _spielbrett.getRote().containsKey(stelle.toString()) ;
	}

}
