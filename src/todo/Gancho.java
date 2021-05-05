package todo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Gancho extends Atmosfera {
	
	double xvel;
	double yvel;
	Personaje personaje;
	double angulo;
	boolean apuntaEnemigo;
	int c = 1;
	
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
		}
		if(Teclado.isSPulsado() && alto <= 400) {
			alto = alto + 10;
		} else if(Teclado.isSPulsado() && alto >= 400) {
			c = 2;
		} else if(alto > 60) {
			alto = alto - 10;
			c = 1;
		}
	}
	
	public void dibujar(Graphics2D g) {

		switch (c) {
		case 1:
			g.setColor(Color.GRAY);
			break;
		case 2:
			g.setColor(Color.RED);
			break;
		}
		g.rotate(angulo, personaje.x+25, personaje.y+25);
		g.fillRect(x,y,ancho,alto);
		
	}
}
