package Werkzeuge.SpaltenAuswahl;

import javax.swing.JPanel;

import Services.SteinSetzerService;

public class SpaltenAuswahlWerkzeug 
{
	private SpaltenAuswahlWerkzeugUI _UI;
	private SteinSetzerService _service;
	
	public SpaltenAuswahlWerkzeug(int breite, SteinSetzerService service)
	{
		_UI = new SpaltenAuswahlWerkzeugUI(breite);
		_service = service;
		registriereUIAktionen();
	}
	
	private void registriereUIAktionen() 
	{
		_UI.getSpaltenwahlPlan().addSpaltenAuswahlListener(new SpaltenListener()
				{

					@Override
					public void auswahlGetaetigt(SpaltenAuswahlEvent e) 
					{
						informiereService(e.getAusgewaehlteSpalte());
					}
			
				});
	}

	public JPanel getUIPanel()
	{
		return _UI.getHauptPanel();
	}
	
	
	public void informiereService(int spalte)
	{
		_service.setzeStein(spalte);
	}
	
	
}
