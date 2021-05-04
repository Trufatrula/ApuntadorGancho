package todo;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;

public class Principal {
	public static void main(String[] args) throws IOException {

		JFrame miPantalla = new JFrame();
		PanelObjeto panel = new PanelObjeto();
		panel.setLocation(0,0);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setVisible(true);
		miPantalla.add(panel);
		miPantalla.setSize(1000,800);
		miPantalla.setTitle("Proyecto Andoni Torres");
		miPantalla.setVisible(true);
		miPantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Entorno.guardarNiveles("prueba.dat");
	}
}