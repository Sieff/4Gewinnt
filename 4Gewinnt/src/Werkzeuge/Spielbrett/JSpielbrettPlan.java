package Werkzeuge.Spielbrett;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import Fachwerte.Stelle;

/**
 * Spielbrettplan als JPanel bestehend aus einem Doppelarray an JPlanPanels
 * 
 * @author Steffen Schubert
 *
 */
public class JSpielbrettPlan extends JPanel
{

	private static final long serialVersionUID = 1L;
	public static Dimension PLANPANEL_GROESSE = new Dimension(22, 22);
	private JPlanPanel[][] _panels;
	
	public JSpielbrettPlan(int hoehe, int breite)
	{
		setLayout(new GridBagLayout());
		_panels = new JPlanPanel[hoehe][breite];
        for (int reihe = 0; reihe < breite; reihe++)
        {
        	
            for (int spalte = 0; spalte < hoehe; spalte++)
            {
                JPlanPanel panel = new JPlanPanel(Stelle.get(reihe, spalte));
                panel.setMinimumSize(PLANPANEL_GROESSE);
                panel.setPreferredSize(PLANPANEL_GROESSE);
                imGitterEinfuegen(panel, reihe, spalte);
                _panels[spalte][reihe] = panel;
            }
        }
        revalidate();
        repaint();
		
	}
	
	/**
	 * F�gt die JPlanPanels im SpielbrettGitter ein
	 * 
	 * @param component Die einzuf�gende Komponente
	 * @param gridx Die Breitenkoordinate
	 * @param gridy Die Hoehenkoordinate
	 */
	private void imGitterEinfuegen(Component component, int gridx, int gridy)
    {
        add(component, new GridBagConstraints(gridx, gridy, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
                        2, 2, 2, 2), 0, 0));
    }
	
	/**
	 * Markiert eine Stelle Blau
	 * 
	 * @param stelle die zu markierende Stelle
	 */
	public void markiereStelleBlau(Stelle stelle)
	{
		_panels[stelle.getHoehenKoordinate()][stelle.getBreitenKoordinate()].setBlau();
		
	}
	
	/**
	 * Markiert eine Stelle rot
	 * 
	 * @param stelle die zu markierende Stelle
	 */
	public void markiereStelleRot(Stelle stelle)
	{
		_panels[stelle.getHoehenKoordinate()][stelle.getBreitenKoordinate()].setRot();
		
	}
}
