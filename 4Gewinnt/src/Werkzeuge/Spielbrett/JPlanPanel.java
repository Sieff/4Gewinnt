package Werkzeuge.Spielbrett;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Fachwerte.Stelle;

/**
 * Ein einzelnes Panel auf dem Spielplan, kann entweder rot, blau oder grau sein
 * 
 * @author Steffen Schubert
 *
 */
public class JPlanPanel extends JPanel
{
    private static final Color FARBE_FREI = Color.GRAY;
    private static final Color FARBE_ROT = Color.RED;
    private static final Color FARBE_BLAU = Color.BLUE;
	
    private final Border defaultBorder = new EmptyBorder(0, 0, 0, 0);
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
	
	/**
	 * Setzt ein Panel rot
	 */
	public void setRot()
	{
		_rot = true;
		repaint();
	}
	
	/**
	 * Setzt ein Panel blau
	 */
	public void setBlau()
	{
		_blau = true;
		repaint();
	}
	
	/**
	 * Gibt Stelle des Panels zur�ck
	 * 
	 * @return die Stelle des Panels
	 */
	public Stelle getStelle()
	{
		return _stelle;
	}
	
	/**
	 * Gibt zur�ck ob das Panel rot ist
	 * 
	 * @return ob das Panel rot ist
	 */
	public boolean getRot()
	{
		return _rot;
	}
	
	/**
	 * Gibt zur�ck ob das Panel blau ist
	 * 
	 * @return ob das Panel blau ist
	 */
	public boolean getBlau()
	{
		return _blau;
	}
	
	@Override
    protected void paintComponent(Graphics g)
    {
        Graphics graphics = g.create();

        try
        {
            Color color = farbeFuerAktuellenZustand();
            graphics.setColor(color);
            Insets borderInsets = currentBorder.getBorderInsets(this);
            RoundRectangle2D.Double viewRect = new RoundRectangle2D.Double();
            viewRect.x = borderInsets.left;
            viewRect.y = borderInsets.top;
            viewRect.width = getWidth() - borderInsets.left
                    - borderInsets.right;
            viewRect.height = getHeight() - borderInsets.top
                    - borderInsets.bottom;
            graphics.fillRoundRect((int) viewRect.x, (int) viewRect.y, (int) viewRect.width,
                    (int) viewRect.height, Integer.MAX_VALUE, Integer.MAX_VALUE );
        }
        finally
        {
            graphics.dispose();
        }
    }

	/**
	 * Gibt die Farbe f�r das Panel zur�ck
	 * 
	 * @return Farbe f�r das Panel
	 */
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
