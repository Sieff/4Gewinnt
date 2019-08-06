package Werkzeuge.Spielbrett;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import Fachwerte.Stelle;

public class JPlanPanel extends JPanel
{
    private static final Color FARBE_FREI = Color.GRAY;
    private static final Color FARBE_ROT = Color.RED;
    private static final Color FARBE_BLAU = Color.BLUE;
	
    private final Border defaultBorder = new BevelBorder(BevelBorder.LOWERED);
    private Border currentBorder = defaultBorder;
    
	private static final long serialVersionUID = 1L;
	
	private Stelle _stelle;
	private boolean _rot;
	private boolean _blau;

	public JPlanPanel(Stelle stelle)
	{
		_stelle = stelle;
		_rot = false;
		_blau = false;
	}
	
	public void setRot()
	{
		_rot = true;
		repaint();
	}
	
	public void setBlau()
	{
		_blau = true;
		repaint();
	}
	
	public Stelle getStelle()
	{
		return _stelle;
	}
	
	public boolean getRot()
	{
		return _rot;
	}
	
	public boolean getBlau()
	{
		return _blau;
	}
	
	@Override
    protected void paintComponent(Graphics g)
    {
        /*
         * Der Button zeichnet sich selbst, weil das Einfaerben basierend auf
         * seinem Zustand mit dem normalen JButton nicht plattformuebergreifend
         * fuer alle Look&Feels funktioniert.
         */

        // Diese Methode soll den Zustand von g nicht veraendern, deshalb wird
        // hier eine Kopie erstellt, mit der dann gearbeitet wird.
        Graphics graphics = g.create();

        try
        {
            // Hintergrund einfaerben
            Color color = farbeFuerAktuellenZustand();
            graphics.setColor(color);
            Insets borderInsets = currentBorder.getBorderInsets(this);
            Rectangle viewRect = new Rectangle();
            viewRect.x = borderInsets.left;
            viewRect.y = borderInsets.top;
            viewRect.width = getWidth() - borderInsets.left
                    - borderInsets.right;
            viewRect.height = getHeight() - borderInsets.top
                    - borderInsets.bottom;
            graphics.fillRect(viewRect.x, viewRect.y, viewRect.width,
                    viewRect.height);
        }
        finally
        {
            graphics.dispose();
        }
    }

	private Color farbeFuerAktuellenZustand() 
	{
		if (_rot)
        {
            return FARBE_ROT;
        }
        else
        {
            if (_blau)
            {
            	return FARBE_BLAU;
            }
            else
            {
                return FARBE_FREI;
            }
        }
	}
	
	
}
