package todo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.*;
import java.util.ArrayList;

public class Entorno extends Atmosfera implements Serializable {
	private static final long serialVersionUID = 1L;
	
	static ArrayList<Entorno> suelo = new ArrayList<>();
	
	public Entorno(int x, int y, int ancho, int alto) {
		super(x, y, ancho, alto);
	}
	
	/**
	 * Sirve para crear filas largas en la coordenada x de suelo.
	 * @param x Cantidad de largo que sera el suelo.
	 * @param y En que altura se creara el suelo
	 */
	public static void construirSuelo(int x, int y) {
		for(int i = 0; i <= x; i+=50) {
			suelo.add(new Entorno(x-i, y, 50, 50));
		}
	}
	
	public void dibujar(Graphics2D g) {
		g.setColor(Color.darkGray);
		g.fillRect(x,y,ancho,alto);
	}
	
	/**
	 * Todavia no puedo usar esto porque no tengo muchas cosas que guardar.
	 * Para hacer la prueba de que funciona he guardado los elementos del entorno.
	 * @param nombre
	 * @throws IOException
	 */
	public static void guardarNiveles(String nombre) throws IOException {
		ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(nombre));
		salida.writeObject(suelo);
		salida.close();
	}
	
}
