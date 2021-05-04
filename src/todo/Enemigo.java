package todo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Enemigo extends Atmosfera{
	
	PanelObjeto panel;
	double xvel;
	double yvel;
	
	public Enemigo(int x, int y, int ancho, int alto, PanelObjeto panel) {
		super(x, y, ancho, alto);
		this.panel = panel;
	}
	
	private static boolean moverD = true;
	private static boolean moverI = false;
	
	public void moverEnemigo() {
		x += (int) xvel;
		y += (int) yvel;	
		colision.x = (int) (x+xvel);
		colision.y = (int) (y+yvel);
		
		if(moverD) {
			xvel=xvel+0.25;
		}
		
		if(moverI) {
			xvel=xvel-0.25;
		}
		
		if(xvel > 0 && xvel < 0.25) {
			xvel = 0;
		}
		if(xvel < 0 && xvel > 0.25) {
			xvel = 0;
		}
		if(xvel > 10) {
			xvel = 10;
		}
		if(xvel < -10) {
			xvel = -10;
		}
		
		yvel  += 0.3;
		
		colision.x += xvel;
		for(int i = 0; i < Entorno.suelo.size(); i++) {
			if(Entorno.suelo.get(i).colision.intersects(colision)){
				colision.x -= xvel;
				while(!Entorno.suelo.get(i).colision.intersects(colision)) {
					colision.x += Math.signum(xvel);
				}
				colision.x -= Math.signum(xvel);
				xvel = 0;
				x = colision.x;
				moverD=!moverD;
				moverI=!moverI;
			}
		}
		
		colision.y += yvel;
		for(int i = 0; i < Entorno.suelo.size(); i++) {
			if(Entorno.suelo.get(i).colision.intersects(colision)) {
				colision.y -= yvel;
				while(!Entorno.suelo.get(i).colision.intersects(colision)) {
					colision.y += Math.signum(yvel);
				}
				colision.y -= Math.signum(yvel);
				yvel = 0;
				y = colision.y;
			}
		}
	}
	
	public void dibujar(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(x,y,ancho,alto);
	}
}

