package todo;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

public class MoverRaton {
	
	Point pointPressed;
	Point pointMovedPrev;
	static Point pointMoved;
	boolean botonIzquierdo;
	boolean botonDerecho;
	boolean botonMedio;
	static Point pMovto = null;
	Point pPuls = getRatonPulsado();
	static Object lock = new Object();
	PanelObjeto panel;
	
	
	public static Point getRatonMovido() {
		synchronized (lock) {
			return pointMoved;
		}
	}
	
	public Point getRatonPulsado() {
		synchronized (lock) {
			return pointPressed;
		}
	}

	public Point getVectorRatonMovido() {
		synchronized (lock) {
			Point ret = new Point( 0, 0 );
			if (pointMovedPrev!=null) {
				ret.setLocation( pointMoved.getX()-pointMovedPrev.getX(), pointMoved.getY()- pointMovedPrev.getY() );
			}
			pointMovedPrev = pointMoved;
			return ret;
		}
	}	
	
	void darle(PanelObjeto panel) {
		panel.addMouseListener( new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				synchronized (lock) {
					pointPressed = null;
				}
			}
			public void mousePressed(MouseEvent e) {
				synchronized (lock) {
					pointPressed = e.getPoint();
					botonIzquierdo = SwingUtilities.isLeftMouseButton(e);
					botonDerecho = SwingUtilities.isRightMouseButton(e);
					botonMedio = SwingUtilities.isMiddleMouseButton(e);
				
				}
			}
		});
		panel.addMouseMotionListener( new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				synchronized (lock) {
					pointMoved = e.getPoint();
				}
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				synchronized (lock) {
					pointPressed = e.getPoint();
					botonIzquierdo = SwingUtilities.isLeftMouseButton(e);
					botonDerecho = SwingUtilities.isRightMouseButton(e);
					botonMedio = SwingUtilities.isMiddleMouseButton(e);
				}
			}
		});
		pMovto = getRatonMovido();
	}
}