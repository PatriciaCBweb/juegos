package juegos;

import juegos.Menu;
import juegos.TresEnRaya;

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
		boolean menu = false; 
		// boolean para volver a menú. Mientras que menu=false --> mostrar menú ?????
		
		Menu m1 = new Menu(MenuTresEnRaya);
		
		m1.setTitulo("TRES EN RAYA");
		m1.mostrarMenu();
		System.out.println();
		
		eleccion = m1.eligeOpcion();
		//System.out.println("Has elegido --> "+m1.MuestraLiteral(eleccion));
		
		//Menú
		switch (eleccion) {
		case 1:
			juegoTresEnRaya();
			break;
		case 2:
			System.out.println("Aquí no hay nada todavía");
			break;
		case 3:
			System.out.println("Aquí no hay nada todavía");
			break;
		case 0:
			System.out.println("Has salido.");
			break;
		default:
			System.out.println("Error.");
			break;
		}
		
		
	}//main
	
	public static void juegoTresEnRaya() {
		TresEnRaya partida = new TresEnRaya();
		partida.inicioPartida();
		partida.mostrarTablero();
		int maxTurno = partida.maxTurno;
		boolean jugador = true;
		int turno=0;
		for(int i=0;i<partida.maxTurno;i++) {
			jugador = !jugador;
			turno += 1;
			//System.out.println(jugador);
			System.out.println();
<<<<<<< HEAD
			System.out.println("Movimiento: "+turno/*partida.sumaTurno()*/);
=======
			System.out.println("Turno: "+turno/*partida.sumaTurno()*/);
>>>>>>> 4b9752450b9e96e0610c33ccb294de6fe05960ed
			int [] posicion = partida.movimientoJugador(jugador);
			if(posicion[0]==33) {
				System.out.println();
				System.out.println("Has abandonado la partida");
				break;
			}
<<<<<<< HEAD
			
			while(!partida.comprobarTablero(posicion)) {
				System.out.println("Posición ocupada.");
				System.out.print("Otra vez ");
				posicion = partida.movimientoJugador(jugador);	
			}
				partida.marcarCelda(posicion,jugador);
			
			
			
=======
			partida.marcarCelda(posicion,jugador);
>>>>>>> 4b9752450b9e96e0610c33ccb294de6fe05960ed
			partida.mostrarTablero();
			System.out.println();
			String result = partida.resultadoJuego(turno);
			if(result == "empate") {
				System.out.println("Fin de la partida. Empate");
				break;
			}
			if(result == "gana1") {
				System.out.println ("¡Felicidades Jugador 1. Has ganado!");
				break;
			}
			if(result == "gana2") {
				System.out.println ("¡Felicidades Jugador 2. Has ganado!");
				break;
			}
			/*posicion = partida.movimientoJugador2();
			partida.marcarCelda(posicion,'O');
			partida.mostrarTablero();*/
		}//for
		
		
	}//juegoTresEnRaya

}//MainApp
