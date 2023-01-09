package juegos;

import juegos.Menu;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//MENU
		String [] MenuTresEnRaya = {
				"Iniciar partida",
				"Tabla de puntuaciones",
				"Créditos"
		};
		int eleccion;
		
		Menu m1 = new Menu(MenuTresEnRaya);
		m1.setTitulo("TRES EN RAYA");
		m1.mostrarMenu();
		System.out.println();
		
		eleccion = m1.eligeOpcion();
		System.out.println("Has elegido --> "+m1.MuestraLiteral(eleccion));
	}//main

}//MainApp
