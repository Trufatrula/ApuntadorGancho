package todo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PanelObjeto extends javax.swing.JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	Personaje personaje;
	Ejecucion ejecucion;
	Enemigo enemigo1;
	Gancho espada;

//	Entorno muro;
	ArrayList<Personaje> ciudadania = new ArrayList<>();
	ArrayList<Enemigo> enemigos = new ArrayList<>();
	
	public PanelObjeto() {	
		personaje = new Personaje(200, 200, 50, 50, this);
		crearPersonajes(0);
		enemigo1 = new Enemigo(100, 600, 30, 30, this);
//		muro = new Entorno(350, 350, 10, 10);
		Entorno.construirSuelo(600,400);
		Entorno.construirSuelo(800,700);
		Entorno.suelo.add(new Entorno(400,380,100,200));
		Entorno.suelo.add(new Entorno(400,0,100,300));
		Entorno.suelo.add(new Entorno(700,670,50,100));
		Entorno.suelo.add(new Entorno(100,670,50,100));
		ejecucion = new Ejecucion(this);
	}
	
	/**
	 * Crear personajes adicionales que se moveran como el principal.
	 * No cuenta al personaje original.
	 * @param p Cantidad de personajes extras
	 */
	public void crearPersonajes(int p) {
		for(int i = 0; i < p; i++) {
			ciudadania.add(new Personaje(60*i,50*i, 50, 50, this));
		}
	}
	
	public void crearEnemigos(int x, int y) {
		enemigos.add(new Enemigo(x,y, 60, 60, this));
	}
	
	public void paint(Graphics graficos) {
		super.paint(graficos);
		Graphics2D g = (Graphics2D) graficos;
		
		for(int i=0; i<Entorno.suelo.size(); i++) {
			Entorno.suelo.get(i).dibujar(g);
		}
		for(int i = ciudadania.size()-1; i>=0; i--) {
			ciudadania.get(i).dibujar(g);
		}
		personaje.dibujar(g);
		enemigo1.dibujar(g);
		personaje.gancho.dibujar(g);
//		muro.dibujar(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

}
