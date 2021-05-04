package todo;

import java.util.Timer;
import java.util.TimerTask;

public class Ejecucion {
	Timer temporizador;
	MoverRaton raton;

	
	public Ejecucion(PanelObjeto panel) {
		temporizador = new Timer();
		raton = new MoverRaton();
		temporizador.schedule(new TimerTask() {
			public void run() {	
				panel.personaje.mover();
				raton.darle(panel);
				panel.enemigo1.moverEnemigo();
				for(int i = 0; i<panel.ciudadania.size();i++) {
					panel.ciudadania.get(i).mover();
				}
				panel.repaint();  //Hay que poner repaint	
			}
		}, 0, 16);	//16 milisegundos para refrescar pantalla
	}
}