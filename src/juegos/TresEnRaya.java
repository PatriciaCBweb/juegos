package juegos;
import java.util.Scanner;

public class TresEnRaya {
	//VARIABLES
	public char [][] tablero = new char[3][3];
	public int turno;
	char fichaJ1 = 'X';
	char fichaJ2 = 'O';
	public final int maxTurno = 9;
	public int jugador;
	
	//CONSTRUCTOR VACÍO
	public TresEnRaya(){}
	
	//CONSTRUCTOR
	public TresEnRaya(char [][] tablero, int turno, char fichaJ1, char fichaJ2, int jugador) {
		this.tablero = tablero;
		this.turno = turno;
		this.fichaJ1 = fichaJ1;
		this.fichaJ2 = fichaJ2;
		this.jugador = jugador;
	}

	//GETTERS y SETTERS
	public char[][] getTablero() {
		return tablero;
	}

	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public char getFichaJ1() {
		return fichaJ1;
	}

	public void setFichaJ1(char fichaJ1) {
		this.fichaJ1 = fichaJ1;
	}

	public char getFichaJ2() {
		return fichaJ2;
	}

	public void setFichaJ2(char fichaJ2) {
		this.fichaJ2 = fichaJ2;
	};
	
	public int getJugador() {
		return jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}
	
	//MÉTODOS
	public void inicioPartida() {
		System.out.println("Ha comenzado una nueva partida");
		System.out.println();
		System.out.println("Posiciones del tablero");
		System.out.println("[0,1][0,2][0,3]");
		System.out.println("[1,1][1,2][1,3]");
		System.out.println("[2,1][2,2][2,3]");
		System.out.println("[A,B] --> A: coordenada 1 y B: coordenada 2");
		System.out.println("33 en A o B para salir");
		System.out.println();
	}//inicioPartida
	
	public char[][] limpiaTablero(){
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				tablero[i][j]=' ';
			}
		}
		return tablero;
	}//limpiaTablero
	
	public void mostrarTablero() {
		System.out.println("Tu tablero de juego:");
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print("["+tablero[i][j]+"]");
			}
			System.out.println();
		}
	}//mostrarTablero
	
	public int sumaTurno() {
		turno +=1;
		return turno;
	}//sumaTurno
	
	public int [] movimientoJugador(boolean jugador) {
		int turnoJugador=0;
		if(jugador == false) {
			turnoJugador = 1;
		}else {
			turnoJugador = 2;
		}
		int [] posicion = new int [2];
		System.out.println("Pone ficha el jugador "+turnoJugador+":");
		Scanner sc = new Scanner(System.in);
		boolean CambioCoord = false;
		char coord;
		int numero;
		
		for(int i=0;i<2;i++) { //bucle para coordenadas A y B		
			//cambio de A a B y viceversa
			CambioCoord = !CambioCoord;
			if(CambioCoord==true) {
				coord = 'A';
				numero = 0;
			}else {
				coord = 'B';
				numero = 1;
			}//fin cambio
			//coordenadas nuevas
			System.out.print("Escribe la coordenada "+coord+": ");
			posicion[numero]=sc.nextInt();
			//Salir del juego
			if(posicion[numero]==33) {
				posicion[0]=33;
				posicion[1]=33;
				return posicion;
			}
			//comprobacion posicion correcta
			if(posicion[numero]<0 || posicion[numero]>2) {
				System.out.println("Error. Escribe coordenada entre 0 y 2: ");
				System.out.print("Escribe la coordenada "+coord+": ");
				posicion[numero]=sc.nextInt();
			}//fin posicion correcta
		}//bucle para coordenadas A y B
		
		//evitar colocar en casilla ocupada
		while(tablero[posicion[0]][posicion[1]]=='X' || tablero[posicion[0]][posicion[1]]=='O') {
			System.out.println("Posición ocupada. Escribe nueva posición: ");
			for(int i=0;i<2;i++) { //bucle para coordenadas A y B		
				//cambio de A a B y viceversa
				CambioCoord = !CambioCoord;
				if(CambioCoord==true) {
					coord = 'A';
					numero = 0;
				}else {
					coord = 'B';
					numero = 1;
				}//fin cambio
				//coordenadas nuevas
				System.out.print("Escribe la coordenada "+coord+": ");
				posicion[numero]=sc.nextInt();
				//Salir del juego
				if(posicion[numero]==33) {
					posicion[0]=33;
					posicion[1]=33;
					return posicion;
				}
				//comprobacion posicion correcta
				if(posicion[numero]<0 || posicion[numero]>2) {
					System.out.println("Error. Escribe coordenada entre 0 y 2: ");
					System.out.print("Escribe la coordenada "+coord+": ");
					posicion[numero]=sc.nextInt();
				}//fin posicion correcta
			}//bucle para coordenadas A y B
		}
				
		return posicion;
	}//movimientoJugador
	
	public void marcarCelda(int [] posicion, boolean jugador) {
		char ficha = ' ';
		if(jugador == false) {
			ficha = fichaJ1;
		} if(jugador == true) {
			ficha = fichaJ2;
		}
		tablero[posicion[0]][posicion[1]] = ficha;
	}//marcarCelda
	
	public String resultadoJuego(int turno) {
		//Empate
		String result = "";
		if(turno==9) {
			result = "empate";
			//System.out.println("Fin de la partida. Empate");		
		}
		//Gana
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(tablero[i][0]=='X' && tablero[i][1]=='X' && tablero[i][2]=='X' || //Gana J1
				   tablero[0][j]=='X' && tablero[1][j]=='X' && tablero[2][j]=='X' ||
				   tablero[0][0]=='X' && tablero[1][1]=='X' && tablero[2][2]=='X' ||
				   tablero[0][2]=='X' && tablero[1][1]=='X' && tablero[2][0]=='X'
				   ) {
					result = "gana1";
					break;
				}//if J1
				if(tablero[i][0]=='O' && tablero[i][1]=='O' && tablero[i][2]=='O' || //Gana J2
				   tablero[0][j]=='O' && tablero[1][j]=='O' && tablero[2][j]=='O' ||
			       tablero[0][0]=='O' && tablero[1][1]=='O' && tablero[2][2]=='O' ||
			       tablero[0][2]=='O' && tablero[1][1]=='O' && tablero[2][0]=='O'
			       ) {
					result = "gana2";
					break;
				}//if J2
			}//for j (columna)
		}//for i (fila)
		return result;
		/*if(tablero[0][0]=='X' && tablero[0][1]=='X' && tablero[0][2]=='X' ||
		   tablero[1][0]=='X' && tablero[1][1]=='X' && tablero[1][2]=='X' ||
		   tablero[2][0]=='X' && tablero[2][1]=='X' && tablero[2][2]=='X' //||
				
				) {
			System.out.println ("¡Felicidades Jugador 1. Has ganado!");
			
		}*/
	}//resultadoJuego
	
	//volver a menú
	
}//TresEnRaya
