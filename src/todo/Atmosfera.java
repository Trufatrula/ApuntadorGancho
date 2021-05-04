package todo;

import java.awt.Rectangle;

public abstract class Atmosfera {
	int x;
	int y;
	int ancho;
	int alto;
	Rectangle colision;

	public Atmosfera(int x, int y, int ancho, int alto) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		colision = new Rectangle();
		colision.setBounds(x, y, ancho, alto);
	}


}
