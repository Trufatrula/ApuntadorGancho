package todo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Personaje extends Atmosfera {
	
	PanelObjeto panel;
	double xvel;
	double yvel;
	Gancho gancho;
	double arriba;
	double abajo1;
	double abajo2;
	
	public Personaje(int x, int y, int ancho, int alto, PanelObjeto panel) {
		super(x, y, ancho, alto);
		this.panel = panel;
		gancho = new Gancho(x+20, y+20, 5, 60, this);
	}
	
	public void mover() {
		
		x += (int) xvel;
		y += (int) yvel;	
		colision.x = (int) (x+xvel);
		colision.y = (int) (y+yvel);
		
		gancho.mover();

		if(Teclado.isDPulsado() && Teclado.isAPulsado() || !Teclado.isDPulsado() && !Teclado.isAPulsado()) {
			xvel *= 0.8;
		} else if(Teclado.isDPulsado() && !Teclado.isAPulsado()) {
			xvel ++;
		} else if(Teclado.isAPulsado() && !Teclado.isDPulsado()) {
			xvel --;
		}
		
		if(xvel > 0 && xvel < 0.75) {
			xvel = 0;
		}
		if(xvel < 0 && xvel > 0.75) {
			xvel = 0;
		}
		if(xvel > 10) {
			xvel = 10;
		}
		if(xvel < -10) {
			xvel = -10;
		}
		
		if(Teclado.isWPulsado()) {
			colision.y++;
			for(int i = 0; i < Entorno.suelo.size(); i++) {
				if(Entorno.suelo.get(i).colision.intersects(colision)) {
					yvel = -6;
				}
			}
			colision.y--;
		}
		
		yvel  += 0.3;
		
		colision.x += xvel;
		for(int i = 0; i < Entorno.suelo.size(); i++) {
			if(Entorno.suelo.get(i).colision.intersects(colision)) {
				colision.x -= xvel;
				while(!Entorno.suelo.get(i).colision.intersects(colision)) {
					colision.x += Math.signum(xvel);
				}
				colision.x -= Math.signum(xvel);
				xvel = 0;
				x = colision.x;
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
			if (panel.enemigo1.colision.intersects(colision)) {
				y = 200;
				x = 200;
		}


		
		//Fisicas alternativas de rebotes en las paredes y con otros objetos
		//No se pueden usar con las fisicas de las lineas 27-84
		
//		if(y >= 750) {
//			y=750;
//			yvel=-yvel;
//		}else yvel += 0.5;
//		
//		if(y <= -1 ) {
//			yvel=-yvel;
//			y=0;
//		}
//		
//		if(x <= 0) {
//			xvel=-xvel;
//			x=0;
//		}
//		
//		if(x >= 950) {
//			xvel=-xvel;
//			x=950;
//		}		
//		
//		if(PanelObjeto.isDPulsado()) {
//			xvel++;
//		}
//		if(PanelObjeto.isAPulsado()) {
//			xvel--;
//		}
//		
//		if(PanelObjeto.isSPulsado()) {
//			yvel++;
//		}
//		if(PanelObjeto.isWPulsado()) {
//			yvel--;
//		}
//		
//		for(int i = 0; i < panel.suelo.size(); i++) {
//			if(panel.suelo.get(i).colision.intersects(colision)) {
//				yvel=0;	
//			}
//		}
//		for(int e = 0; e < panel.ciudadania.size(); e++) {
//			if(panel.ciudadania.get(e).colision.intersects(this.colision) && panel.ciudadania.get(e).colision != this.colision) {
//				xvel=-xvel;
//				yvel=-yvel;
//			}
//		}
	}
	
	public void dibujar(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(x,y,ancho,alto);
	}

}
