package vista;

import java.awt.Color;

import javax.swing.JPanel;

import modelo.Libro;
import utiles.ButtonsTools;

public class VistaHeredable extends JPanel{
	protected final Color TEMA1[] = {new Color(0, 255, 255),new Color(255, 215, 0),new Color(255, 230, 230)};
	protected final Color TEMA_OSCURO[] = {Color.BLACK,new Color(160,160,160)};
	
	public void oscuro() {
	}
	public void claro() {
	}
	public void tema1() {
	}
	public void vaciarCampos() {
	}
	public boolean comprobarCampos() {return false;}
}
