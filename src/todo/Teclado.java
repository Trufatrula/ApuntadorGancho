package todo;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class Teclado {

	private static boolean teclaA = false;
	private static boolean teclaD = false;
	private static boolean teclaS = false;
	private static boolean teclaW = false;
	private static boolean teclaR = false;
	
	private static void init() {
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		manager.addKeyEventDispatcher( new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					if (e.getKeyCode() == KeyEvent.VK_A) teclaA = true; 
					if (e.getKeyCode() == KeyEvent.VK_D) teclaD = true; 
					if (e.getKeyCode() == KeyEvent.VK_S) teclaS = true; 
					if (e.getKeyCode() == KeyEvent.VK_W) teclaW = true;
					if (e.getKeyCode() == KeyEvent.VK_R) teclaR = true; 
				} else if (e.getID() == KeyEvent.KEY_RELEASED) {
					if (e.getKeyCode() == KeyEvent.VK_A) teclaA = false; 
					if (e.getKeyCode() == KeyEvent.VK_D) teclaD = false; 
					if (e.getKeyCode() == KeyEvent.VK_S) teclaS = false; 
					if (e.getKeyCode() == KeyEvent.VK_W) teclaW = false; 
					if (e.getKeyCode() == KeyEvent.VK_R) teclaR = false; 

				} else if (e.getID() == KeyEvent.KEY_TYPED) {
				}
				return false; 
			} } );
	}
	static {  
		init();
	}
	
	public static boolean isAPulsado() {
		return teclaA;
	}
	public static boolean isDPulsado() {
		return teclaD;
	}
	public static boolean isSPulsado() {
		return teclaS;
	}
	public static boolean isWPulsado() {
		return teclaW;
	}
	public static boolean isRPulsado() {
		return teclaR;
	}
}
