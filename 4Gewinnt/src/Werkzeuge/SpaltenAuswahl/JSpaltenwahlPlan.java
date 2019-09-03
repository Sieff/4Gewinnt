package Werkzeuge.SpaltenAuswahl;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * JComponent für den Plan für die Spaltenauswwahl, bestehend aus einem Array an Buttons
 * 
 * @author steff
 *
 */
public class JSpaltenwahlPlan extends JPanel
{
	public static Dimension SPALTENBUTTON_GROESSE = new Dimension(40, 40);
	private static final long serialVersionUID = 1L;
	private JButton[] _buttons;
	private List<SpaltenListener> _listener;
	private ActionListener _buttonListener;
	
	public JSpaltenwahlPlan(int breite)
	{
		setLayout(new FlowLayout());
		erzeugeSpaltenAuswahlListener();
		_buttons = new JButton[breite];
		erzeugeButtons(breite);
		_listener = new ArrayList<SpaltenListener>();
	}
	
	/**
	 * Erzeugt mehrere Buttons für das ButtonArray
	 * 
	 * @param breite die Breite des ButtonArrays
	 */
	private void erzeugeButtons(int breite)
	{
		for (int spalte = 0; spalte < breite; spalte++)
        {
            JButton button = new JButton();
            button.setMargin(new Insets(0, 0, 0, 0));
            button.setText(spalte+1 + "");
            button.setMinimumSize(SPALTENBUTTON_GROESSE);
            button.setPreferredSize(SPALTENBUTTON_GROESSE);
            button.addActionListener(_buttonListener);
            inReiheEinfuegen(button, 1, spalte);
            _buttons[spalte] = button;
        }
	}

	/**
	 * Fügt componenten in der Reihe ein
	 * 
	 * @param component die einzufügende Komponnente 
	 * @param gridx Die Hoehenkoordinate im GridBagLayout
	 * @param gridy Die Breitenkoordinate im GridBagLayout
	 */
	private void inReiheEinfuegen(Component component, int gridx, int gridy)
    {
        add(component, new GridBagConstraints(gridx, gridy, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
                        2, 2, 2, 2), 0, 0));
    }
	
	/**
	 * Gibt das Buttonarray zurück
	 * 
	 * @return die Buttons
	 */
	public JButton[] getButtons()
	{
		return _buttons;
	}
	
	/**
	 * Fügt einen Listener zur Spaltenauswahl hinzu
	 * 
	 * @param spaltenListener Der Listener der Hinzugefügt werden soll
	 */
	public void addSpaltenAuswahlListener(SpaltenListener spaltenListener) 
	{
		_listener.add(spaltenListener);
	}
	
	/**
	 * Erzeugt Listener für den Button
	 */
	private void erzeugeSpaltenAuswahlListener()
    {
        _buttonListener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JButton button = (JButton) e.getSource();
                informiereSpaltenAuswahlListener(Integer.parseInt(button.getText()));
            }

        };
    }
	
	/**
	 * Informiert alle SpaltenAuswahlListener über das SpaltenAuswahlEvent
	 * 
	 * @param spalte Die ausgewählte Spalte
	 */
	private void informiereSpaltenAuswahlListener(int spalte) 
	{
		SpaltenAuswahlEvent e = new SpaltenAuswahlEvent(this, spalte);
		for(SpaltenListener s : _listener)
		{
			s.auswahlGetaetigt(e);
		}
		
	}
}
