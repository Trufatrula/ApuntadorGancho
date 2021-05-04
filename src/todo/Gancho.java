package todo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Gancho extends Atmosfera {
	
	double xvel;
	double yvel;
	Personaje personaje;
	double angulo;
	boolean apuntaEnemigo;
	
	public Gancho(int x, int y, int ancho, int alto, Personaje personaje) {
		super(x, y, ancho, alto);
		this.personaje = personaje;
	}
	
	public void mover() {
		
		x = (int) (personaje.x+25);
		y = (int) (personaje.y+25);
		colision.x = x;
		colision.y = y;
//		System.out.println();
		
		if(MoverRaton.pMovto != null) {				
			angulo = Math.atan2(y - MoverRaton.pMovto.getY(), x - MoverRaton.pMovto.getX()) + Math.PI / 2;
//			if((int) MoverRaton.pMovto.getX() == personaje.panel.enemigo1.x && (int) MoverRaton.pMovto.getY() == personaje.panel.enemigo1.y) {
//				apuntaEnemigo = true;
		}
	}
	
	public void dibujar(Graphics2D g) {

		if (apuntaEnemigo) {
			g.setColor(Color.RED);
//		} else if(x<=300) {
//			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.GRAY);
		}
		
		g.rotate(angulo, personaje.x+25, personaje.y+25);
		g.fillRect(x,y,ancho,alto);
		
	}
}
