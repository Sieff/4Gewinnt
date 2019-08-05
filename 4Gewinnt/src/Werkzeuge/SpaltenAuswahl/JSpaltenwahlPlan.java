package Werkzeuge.SpaltenAuswahl;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;


public class JSpaltenwahlPlan extends JPanel
{
	public static Dimension SPALTENBUTTON_GROESSE = new Dimension(40, 40);
	private static final long serialVersionUID = 1L;
	private JButton[] _buttons;
	
	public JSpaltenwahlPlan(int breite)
	{
		setLayout(new FlowLayout());
		_buttons = new JButton[breite];
		
		for (int spalte = 0; spalte < breite; spalte++)
        {
            JButton button = new JButton();
            button.setMargin(new Insets(0, 0, 0, 0));
            button.setText(spalte+1 + "");
            button.setMinimumSize(SPALTENBUTTON_GROESSE);
            button.setPreferredSize(SPALTENBUTTON_GROESSE);
            imGitterEinfuegen(button, 1, spalte);
            _buttons[spalte] = button;
        }
		
	}
	
	private void imGitterEinfuegen(Component component, int gridx, int gridy)
    {
        add(component, new GridBagConstraints(gridx, gridy, 1, 1, 1.0, 1.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
                        2, 2, 2, 2), 0, 0));
    }
	
	public JButton[] getButtons()
	{
		return _buttons;
	}
}
