package Werkzeuge.SpaltenAuswahl;

import java.util.EventListener;

public interface SpaltenListener extends EventListener 
{
	void auswahlGetaetigt(SpaltenAuswahlEvent e);
}
