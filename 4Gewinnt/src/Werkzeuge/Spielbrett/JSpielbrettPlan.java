package Werkzeuge.Spielbrett;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Set;

import javax.swing.JPanel;

import Fachwerte.Stelle;

public class JSpielbrettPlan extends JPanel
{
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
	
	private void imGitterEinfuegen(Component component, int gridx, int gridy)
    {
        add(component, new GridBagConstraints(gridx, gridy, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
                        2, 2, 2, 2), 0, 0));
    }
	
	public void markiereStelleBlau(Stelle stelle)
	{
		_panels[stelle.getHoehenKoordinate()][stelle.getBreitenKoordinate()].setBlau();
		
	}
	
	public void markiereStelleRot(Stelle stelle)
	{
		_panels[stelle.getHoehenKoordinate()][stelle.getBreitenKoordinate()].setRot();
		
	}
	
	
	
	
	private static final long serialVersionUID = 1L;

}
